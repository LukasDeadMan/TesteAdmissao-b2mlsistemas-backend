/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain.enums;

/**
 *
 * @author lucas
 */
public enum Titulacao {
    
    PROFESSORCOLABORADOR(1, "Professor Colaborador"),
    PROFESSORDOUTOR(2, "Professor Doutor"),
    PROFESSORTITULAR(3, "Professor Titular");
    
    private int cod;
    private String descricao;

    private Titulacao(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static Titulacao toEnum(Integer cod) {
        
        if(cod == null) {
            return null;
        }
        
        for( Titulacao x : Titulacao.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
