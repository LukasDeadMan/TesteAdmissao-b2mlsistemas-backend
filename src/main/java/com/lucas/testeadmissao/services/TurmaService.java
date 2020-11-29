/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.Turma;
import com.lucas.testeadmissao.repositories.TurmaRepository;
import com.lucas.testeadmissao.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository repo;
    
    public Turma find (Integer id) {
        Optional<Turma> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
    }
}
