/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucas.testeadmissao.domain.interfaces.iTurma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
public class Turma implements Serializable, iTurma {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    private String sala;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAbertura;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEncerramento;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @OneToMany(mappedBy = "id.turma")
    private Set<AlunoTurma> alunos = new HashSet<>();

    public Turma(String codigo, String sala, Date dataAbertura, Date dataEncerramento, Professor professor) {
        this.codigo = codigo;
        this.sala = sala;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.professor = professor;
    }

    public Turma() {
    }
    
    public List<Aluno> getListaAlunos() {
        List<Aluno> lista = new ArrayList<>();
        for (AlunoTurma x : alunos){
            lista.add(x.getAluno());
        }
        return lista;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public Boolean estaAberta() {
        return true;
    }

    @Override
    public void definirProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public void incluirAluno(Aluno aluno) {
        
    }


    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<AlunoTurma> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<AlunoTurma> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.codigo);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }


}
