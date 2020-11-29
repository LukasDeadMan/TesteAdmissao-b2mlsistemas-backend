/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.Aluno;
import com.lucas.testeadmissao.repositories.AlunoRepository;
import com.lucas.testeadmissao.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
}
