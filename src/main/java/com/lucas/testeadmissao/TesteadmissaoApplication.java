package com.lucas.testeadmissao;

import com.lucas.testeadmissao.domain.Aluno;
import com.lucas.testeadmissao.domain.Professor;
import com.lucas.testeadmissao.domain.Turma;
import com.lucas.testeadmissao.domain.enums.Titulacao;
import com.lucas.testeadmissao.repositories.AlunoRepository;
import com.lucas.testeadmissao.repositories.ProfessorRepository;
import com.lucas.testeadmissao.repositories.TurmaRepository;
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
    @Autowired
    private TurmaRepository turmaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TesteadmissaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Aluno aluno1 = new Aluno(null, "1201610303", "Lucas Soares");
        Aluno aluno2 = new Aluno(null, "1201610444", "Daniel Fernandes");
        
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
        
        Professor prof1 = new Professor(null, "Diego Paiva", Titulacao.PROFESSORCOLABORADOR);
        Professor prof2 = new Professor(null, "Gustavo Vieira", Titulacao.PROFESSORTITULAR);
        
        professorRepository.saveAll(Arrays.asList(prof1, prof2));
        
        
        
        
    }

}
