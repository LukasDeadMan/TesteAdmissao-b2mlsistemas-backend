/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.repositories.ProfessorRepository;
import com.lucas.testeadmissao.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
}
