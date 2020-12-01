/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain;

import com.lucas.testeadmissao.domain.interfaces.iUsuarios;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
public class Aluno implements Serializable, iUsuarios {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String matricula;
    private String nome;
    @OneToMany(mappedBy = "id.aluno")
    private Set<AlunoTurma> turmas = new HashSet<>();

    public Aluno() {
    }

    public Aluno(Integer id, String matricula, String nome) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public void definirNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String obterNome() {
        return nome;
    }

    @Override
    public void definirMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String obterMatricula() {
        return matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<AlunoTurma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<AlunoTurma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
