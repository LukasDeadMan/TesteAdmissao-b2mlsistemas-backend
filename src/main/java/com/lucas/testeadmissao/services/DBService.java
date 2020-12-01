/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.services;

import com.lucas.testeadmissao.domain.Aluno;
import com.lucas.testeadmissao.domain.AlunoTurma;
import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.domain.Turma;
import com.lucas.testeadmissao.repositories.AlunoRepository;
import com.lucas.testeadmissao.repositories.AlunoTurmaRepository;
import com.lucas.testeadmissao.repositories.ProfessorRepository;
import com.lucas.testeadmissao.repositories.TurmaRepository;
import com.lucas.testeadmissao.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class DBService {
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;
    
    @Autowired
    private AlunoTurmaRepository alunoTurmaRepository;
    
    private static ObjectUtils objUtils = new ObjectUtils();

    public void instantiateTestDatabase() throws ParseException {
        Professor prof1 = new Professor(null, objUtils.generateMatricula("professor"),"Lucas Soares", 1);
        Professor prof2 = new Professor(null,objUtils.generateMatricula("professor"),"Adriano Ribeiro", 2);
        
        professorRepository.saveAll(Arrays.asList(prof1, prof2));
        
        Aluno aluno1 = new Aluno (null, objUtils.generateMatricula("aluno"),"André Silva");
        Aluno aluno2 = new Aluno (null, objUtils.generateMatricula("aluno") ,"Tarcisio Alves");
        Aluno aluno3 = new Aluno (null, objUtils.generateMatricula("aluno"),"Larissa Henrique");
        
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd//MM/yyyy");
        
        
        Turma turma1 = new Turma (null, "1412", "Sala 01", null,
                                   null, prof1);
        Turma turma2 = new Turma (null, "1511", "Sala 02", null,
                                  null, prof2);
        
        turmaRepository.saveAll(Arrays.asList(turma1, turma2));
        
        AlunoTurma at1 = new AlunoTurma(aluno1,turma1);
        AlunoTurma at2 = new AlunoTurma(aluno2,turma1);
        AlunoTurma at3 = new AlunoTurma(aluno3,turma1);
       
        
        alunoTurmaRepository.saveAll(Arrays.asList(at1, at2, at3));
        
    }
    
}
