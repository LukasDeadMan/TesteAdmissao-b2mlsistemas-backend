/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author lucas
 */
@Entity
public class AlunoTurma implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @EmbeddedId
    private AlunoTurmaPK id = new AlunoTurmaPK();

    public AlunoTurma() {
    }
    
    public AlunoTurma(Aluno aluno, Turma turma) {
        id.setAluno(aluno);
        id.setTurma(turma);
    }

    public AlunoTurmaPK getId() {
        return id;
    }

    public void setId(AlunoTurmaPK id) {
        this.id = id;
    }
    
    public Aluno getAluno() {
        return id.getAluno();
    }
    
    public Turma getTurma() {
        return id.getTurma();
    }
    
}
