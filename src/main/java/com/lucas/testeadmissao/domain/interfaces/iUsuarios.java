/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain.interfaces;

/**
 *
 * @author lucas
 */
public interface iUsuarios {
    public void definirNome(String nome);
    public String obterNome();
    public void definirMatricula(String matricula);
    public String obterMatricula();
}
