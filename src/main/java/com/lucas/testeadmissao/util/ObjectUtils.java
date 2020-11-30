/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.testeadmissao.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author lucas
 */
public class ObjectUtils implements Serializable {
    private static final long serialVersionUID = 1L;

    private final LocalDate localDate = LocalDate.now();
    private final Random random = new Random();
    

    public String generateMatricula(String indentifier) {
        String matricula = null;
        try {
            if ("aluno".equals(indentifier)) {
                matricula = "1";
            } else if ("professor".equals(indentifier)) {
                matricula = "2";
            }

            matricula = matricula + Integer.toString(localDate.getYear());

            if (localDate.getMonthValue() <= 6) {
                matricula = matricula + "1";
            } else {
                matricula = matricula + "2";
            }

            Integer rand = random.nextInt(9999);

            if (rand <= 9) {
                matricula = matricula + "000" + Integer.toString(rand);
            } else if (rand <= 99) {
                matricula = matricula + "00" + Integer.toString(rand);
            } else if (rand <= 999) {
                matricula = matricula + "0" + Integer.toString(rand);
            } else {
                matricula = matricula + Integer.toString(rand);
            }

            return matricula;

        } catch (Exception e) {
        }
        return matricula;
    }
}
