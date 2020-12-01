/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.repositories;

import com.lucas.testeadmissao.domain.AlunoTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface AlunoTurmaRepository extends JpaRepository<AlunoTurma, Integer> {
     
    
}
