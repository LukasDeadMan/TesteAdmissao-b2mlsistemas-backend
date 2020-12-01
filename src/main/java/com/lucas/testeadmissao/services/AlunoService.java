/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.Aluno;
import com.lucas.testeadmissao.dto.AlunoDTO;
import com.lucas.testeadmissao.repositories.AlunoRepository;
import com.lucas.testeadmissao.services.exceptions.DataIntegrityException;
import com.lucas.testeadmissao.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository repo;
    
    
    public Aluno find (Integer id) {
        Optional<Aluno> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }
    
    public Aluno insert (Aluno obj) {
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Aluno update (Aluno obj) {
        find(obj.getId());
        return repo.save(obj);
    }
    
    public void delete (Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Aluno "
                    + "que possui Turmas! ");
        }
        
    }
    
    public List<Aluno> finAll() {
        return repo.findAll();
    }
    
    public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, 
            String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
                Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
    
    public Aluno fromDTO(AlunoDTO objDto) {
        return new Aluno(objDto.getId(), objDto.getMatricula(), 
                objDto.getNome());
    }
    

    public Aluno fromUpdateDTO(Integer id, AlunoDTO objDto) { 
        Aluno obj = find(id);
        return new Aluno(obj.getId(), obj.obterMatricula(), objDto.getNome());
    }
}
