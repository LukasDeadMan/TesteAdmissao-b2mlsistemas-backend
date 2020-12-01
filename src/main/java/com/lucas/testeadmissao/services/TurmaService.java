/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.AlunoTurma;
import com.lucas.testeadmissao.domain.Turma;
import com.lucas.testeadmissao.repositories.AlunoTurmaRepository;
import com.lucas.testeadmissao.repositories.TurmaRepository;
import com.lucas.testeadmissao.services.exceptions.DataIntegrityException;
import com.lucas.testeadmissao.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repo;

    @Autowired
    private AlunoTurmaRepository alunoTurmarRepo;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ProfessorService professorService;

    public Turma find(Integer id) {
        Optional<Turma> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
    }

    public Turma insert(Turma obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Turma insertAluno(Turma obj, Integer id) {
        find(id);
        if (obj.getProfessor() == null) {
            obj.setProfessor(null);
        } else {
            obj.setProfessor(professorService.find(obj.getProfessor().getId()));
        }

        
        return repo.save(obj);
    }

    public Turma update(Turma obj, Integer id) {
        Turma newObj = find(id);
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Turma "
                    + "que possui Alunos ou Professor! ");
        }

    }

    public List<Turma> finAll() {
        return repo.findAll();
    }

    public Page<Turma> findPage(Integer page, Integer linesPerPage, String orderBy,
            String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    private void updateData(Turma newObj, Turma obj) {
        newObj.setCodigo(obj.getCodigo());
        newObj.setSala(obj.getSala());
        newObj.setDataAbertura(obj.getDataAbertura());
        newObj.setDataEncerramento(obj.getDataEncerramento());
        newObj.setProfessor(obj.getProfessor());
    }

}
