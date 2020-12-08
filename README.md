## Teste Admissional

Este projeto faz parte do teste admissional para a empresa B2ml, que consiste em um Back-end de uma aplicação web.

### Back-end

Aplicação REST API desenvolvida com Java 8 e Spring Boot 2.4.0.

### Inicializando o projeto

Para inicializar o back-end, siga os passos abaixo:

1- Criar um banco de dados vazio com o nome TesteAdmissao no PostgreSQL.

2- Abra o NetBeans e importe como um projeto Maven existente.

3- Na árvore de projetos do NetBeans, clique com o botão direito sobre o nome do projeto e atualize o projeto com o Maven.

   OU
   
   Rode o comando <b><i>mvn install</i></b> no diretório do projeto através do Terminal (Linux).

4- Após o item anterior ser finalizado abra a classe principal <b><i>AdmissionalApplication.java</i></b> e execute a aplicação.

   OU
   
   Rode o comando <b><i>mvn spring-boot:run</i></b> no diretório do projeto através do Terminal (Linux).

5- Se tudo estiver correto, o projeto já estará rodando.
   O projeto ja está com uma carga inicial para o Banco de Dados.

6- Caso queira testar os endpoints fora da aplicação, os acessos podem ser feitos de alguma ferramenta que teste requisições, como o Insomnia.
   Disponibilizei meu arquivo json para testes de requisições no Insomnia, ele se encontra junto com o pom.xml.

### Dependência

Para que o projeto seja corretamente executado, é necessário se atentar para algumas configurações no arquivo application-dev.properties.

Nele há algumas informações que precisam ser modificadas para o acesso ao banco de dados PostgreSQL.

1- <b><i>spring.datasource.url = jdbc:postgresql://localhost:5432/admissional</i></b>: Foram utilizadas a url e a porta padrão para o banco PostgreSQL, porém podem ser alteradas de acordo com as suas configurações.

2- <b><i>spring.datasource.username = postgres</i></b>: Alterar o usuário do banco de acordo com suas configurações.

3- <b><i>spring.datasource.password = 123</i></b>: Alterar a senha do usuário para o banco de acordo com suas configurações.

### Stack utilizada

1- IDE: Netbeans 8.2

2- Servidor Web: Tomcat 9.0.39

3- JDK/JRE: 8

4- Banco de Dados: PostgreSQL 12.5

### Opcional

Deixei a opção de uso do Banco em memória H2, pára usa-lo é só mudar <b><i>application.properties</i></b>. Tem que mudar <b><i>spring.profiles.active=dev</i></b> para <b><i>spring.profiles.active=test</i></b>.
Assim não será preciso configurar o PostgreSQL, é só acessar através do caminho localhost:8080/h2-console.
