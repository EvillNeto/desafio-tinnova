<h1 align="center">Desafio Tinnova </h1>

### :zap: Atalhos de uso:

- [Swagger Ui](http://localhost:8080/swagger-ui/index.html)

- [Banco H2](http://localhost:8080/h2-console)

### :rocket: Setup
- é recomendado possuir uma versão do Java igual ou superior a 17, pois a api utiliza o Java 17
- A api vem com todas as configurações prontas para a porta 8080
- Rodar o projeto pode ser feito pela sua IDE de preferencia ou atraves do terminal caso sua maquina tenha maven instalado lançando o comando a seguir no root do projeto

~~~
mvn spring-boot:run
~~~

### :pushpin: Desafios:

- Desafios de logica: 
    - [x] Calculo de porcentagens para votação
    - [x] Algoritom bubble sort
    - [x] Calculo de fatorial
    - [x] Soma de multiplos de 3 e 5
- Desafio de Cadastro de veiculos: 
    - [x] Cadastro de veiculos
    - [x] Atualização total de veiculos
    - [x] Atualização parcial de veiculos
    - [x] Deletar cadastro de veiculos
    - [x] Busca de veiculos cadastrados com filtros

### :bookmark_tabs: Funcionalidades

- A api possui documentação feita através do [Swagger](http://localhost:8080/swagger-ui/index.html) com descrições para cada metodo
- O banco de dados [H2](http://localhost:8080/h2-console) pode ser acessado por um atalho na tela do swagger e possui as configurações de acesso:
~~~
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:desafio
spring.datasource.username=sa
spring.datasource.password=
~~~
![Configuração h2](https://i.imgur.com/y1ADfuL.png)
- A api é dividida em duas partes: v1 e v2 
- A v1 é dedicada ao Desafio de cadastro de veiculos.
- A v2 é dedicada para os desafio de logica.


### :dart: Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Git](https://git-scm.com)
- [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring](https://spring.io/)
- Jpa Specification
- Swagger
- Lombok