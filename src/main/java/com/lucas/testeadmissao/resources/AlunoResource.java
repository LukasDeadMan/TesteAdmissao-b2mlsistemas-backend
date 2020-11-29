/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.resources;

import com.lucas.testeadmissao.domain.Aluno;
import com.lucas.testeadmissao.services.AlunoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
    
    @Autowired
    private AlunoService service;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Aluno> find (@PathVariable Integer id) {
        Aluno obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
