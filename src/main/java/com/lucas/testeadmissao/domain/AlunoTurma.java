/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
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
    
    public void setAluno(Aluno aluno) {
        id.setAluno(aluno);
    }

    @JsonIgnore
    public Turma getTurma() {
        return id.getTurma();
    }
    
     public void setTurma(Turma turma) {
        id.setTurma(turma);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlunoTurma other = (AlunoTurma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
