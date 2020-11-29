package com.lucas.testeadmissao;

import com.lucas.testeadmissao.domain.Aluno;
import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.repositories.AlunoRepository;
import com.lucas.testeadmissao.repositories.ProfessorRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteadmissaoApplication implements CommandLineRunner {
    
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    public static void main(String[] args) {
        SpringApplication.run(TesteadmissaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Aluno aluno1 = new Aluno(null, "1201610303", "Lucas Soares");
        Aluno aluno2 = new Aluno(null, "1201610444", "Daniel Fernandes");
        
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
        
        Professor prof1 = new Professor(null, "Diego Paiva", "Doutorado");
        Professor prof2 = new Professor(null, "Gustavo Vieira", "Mestrado");
        
        professorRepository.saveAll(Arrays.asList(prof1, prof2));
    }

}
