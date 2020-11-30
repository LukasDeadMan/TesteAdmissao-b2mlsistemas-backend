/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.dto;

import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.domain.enums.Titulacao;
import com.lucas.testeadmissao.domain.interfaces.iUsuarios;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author lucas
 */

public class ProfessorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String matricula;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres!")
    private String nome;
    @NotNull(message = "Preenchimento obrigatório")
    private Integer titulacao;

    public ProfessorDTO() {
    }
    
    public ProfessorDTO(Professor obj) {
        this.id = obj.getId();
        this.matricula = obj.obterMatricula();
        this.nome = obj.obterNome();
        this.titulacao = obj.getTitulacao().getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Titulacao getTitulacao() {
        return Titulacao.toEnum(titulacao);
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao.getCod();
    }
    

    
}
