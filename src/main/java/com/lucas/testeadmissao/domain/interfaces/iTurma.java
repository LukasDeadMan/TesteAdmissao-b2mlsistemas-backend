/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.domain.interfaces;

import com.lucas.testeadmissao.domain.AlunoTurma;
import com.lucas.testeadmissao.domain.Professor;

/**
 *
 * @author lucas
 */
public interface iTurma {
    public Boolean estaAberta();
    public void definirProfessor(Professor professor);
    public void incluirAluno(AlunoTurma aluno);
}
