/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain;

import com.lucas.testeadmissao.domain.enums.Titulacao;
import com.lucas.testeadmissao.domain.interfaces.iUsuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class Professor implements Serializable, iUsuarios {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String matricula;
    private String nome;
    private Integer titulacao;
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas = new ArrayList<>();

    public Professor(Integer id, String matricula, String nome, Integer titulacao) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public Professor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Titulacao getTitulacao() {
        return Titulacao.toEnum(titulacao);
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao.getCod();
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
