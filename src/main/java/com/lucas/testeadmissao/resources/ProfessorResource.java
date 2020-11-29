/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.resources;

import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.services.ProfessorService;
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
@RequestMapping(value = "/Professores")
public class ProfessorResource {
    
    @Autowired
    private ProfessorService service;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> find (@PathVariable Integer id) {
        Professor obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
