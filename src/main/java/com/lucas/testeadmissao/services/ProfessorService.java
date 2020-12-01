/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.dto.ProfessorDTO;
import com.lucas.testeadmissao.repositories.ProfessorRepository;
import com.lucas.testeadmissao.services.exceptions.DataIntegrityException;
import com.lucas.testeadmissao.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository repo;
    
    public Professor find (Integer id) {
        Optional<Professor> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
    }
    
    public Professor insert (Professor obj) {
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Professor update (Professor obj) {
        find(obj.getId());
        return repo.save(obj);
    }
    
    public void delete (Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Professor "
                    + "que possui Turmas! ");
        }
        
    }
    
    public List<Professor> finAll() {
        return repo.findAll();
    }
    
    public Page<Professor> findPage(Integer page, Integer linesPerPage, String orderBy, 
            String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
                Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
    
    public Professor fromDTO(ProfessorDTO objDto) {
        return new Professor(objDto.getId(), objDto.getMatricula(), 
                objDto.getNome(), objDto.getTitulacao().getCod());
    }
    

    public Professor fromUpdateDTO(Integer id, ProfessorDTO objDto) { 
        Professor obj = find(id);
        return new Professor(obj.getId(), obj.obterMatricula(), 
                objDto.getNome(), objDto.getTitulacao().getCod());
    }
}
