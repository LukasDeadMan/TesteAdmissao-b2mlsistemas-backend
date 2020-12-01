/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.dto;

import com.lucas.testeadmissao.domain.Aluno;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author lucas
 */

public class AlunoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String matricula;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 4, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres!")
    private String nome;


    public AlunoDTO() {
    }
    
    public AlunoDTO(Aluno obj) {
        this.id = obj.getId();
        this.matricula = obj.obterMatricula();
        this.nome = obj.obterNome();
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
    
}
