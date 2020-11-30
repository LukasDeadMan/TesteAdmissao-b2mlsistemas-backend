/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.resources;

import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.dto.ProfessorDTO;
import com.lucas.testeadmissao.services.ProfessorService;
import com.lucas.testeadmissao.util.ObjectUtils;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService service;
    
    private static ObjectUtils objUtils = new ObjectUtils();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> find(@PathVariable Integer id) {
        Professor obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ProfessorDTO objDto) {
        objDto.setMatricula(objUtils.generateMatricula("professor"));
        Professor obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ProfessorDTO objDto,
            @PathVariable Integer id) {
        ResponseEntity<Professor> entity = find(id);
        Professor obj = service.fromUpdateDTO(entity, objDto);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProfessorDTO>> findAll() {
        List<Professor> list = service.finAll();
        List<ProfessorDTO> listDto = list.stream()
                .map(obj -> new ProfessorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseEntity<Page<ProfessorDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Professor> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ProfessorDTO> listDto = list.map(obj -> new ProfessorDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }
}
