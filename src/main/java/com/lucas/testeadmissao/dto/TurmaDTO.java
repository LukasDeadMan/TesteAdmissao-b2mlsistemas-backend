/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.domain.Turma;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author lucas
 */
public class TurmaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    private String codigo;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 20, message = "O tamanho deve ser entre 5 e 20 caracteres!")
    private String sala;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataAbertura;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataEncerramento;
    private Professor professor;

    public TurmaDTO() {
    }

    public TurmaDTO(Turma obj) {
        this.id = obj.getId();
        this.codigo = obj.getCodigo();
        this.sala = obj.getSala();
        this.dataAbertura = obj.getDataAbertura();
        this.dataEncerramento = obj.getDataEncerramento();
        this.professor = obj.getProfessor();
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

}
