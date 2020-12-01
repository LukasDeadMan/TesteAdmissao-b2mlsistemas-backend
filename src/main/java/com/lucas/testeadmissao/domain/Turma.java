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
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author lucas
 */
@Entity
public class Turma implements Serializable, iTurma {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Column(unique = true)
    private String codigo;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 20, message = "O tamanho deve ser entre 5 e 20 caracteres!")
    private String sala;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Preenchimento obrigatório")
    private Date dataAbertura;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Preenchimento obrigatório")
    private Date dataEncerramento;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
    @OneToMany(mappedBy = "id.turma")
    private Set<AlunoTurma> alunos = new HashSet<>();

    public Turma(Integer id, String codigo, String sala, Date dataAbertura, Date dataEncerramento, Professor professor) {
        this.id = id;
        this.codigo = codigo;
        this.sala = sala;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.professor = (professor == null) ? null :professor;
    }

    public Turma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Boolean getOpen() {
        return estaAberta();
    }
    
    @Override
    public Boolean estaAberta() {
        Date instant = new Date();
        return dataEncerramento.after(instant);
    }

    @Override
    public void definirProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public void incluirAluno(Aluno aluno) {
        AlunoTurma at = new AlunoTurma();
        at.setAluno(aluno);
        alunos.add(at);
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
