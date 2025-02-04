# 🌐 API SVSA Dashboard

## 📜 Sobre este projeto

Este projeto foi desenvolvido como parte do Trabalho de Conclusão de Curso (TCC) dos alunos Andre Franco e João Victor Araujo Corrêa 🎓.

Esta API é responsável por fornecer os dados utilizados pelo dashboard gerencial dos serviços de assistência social da Estância Turística de Salto. O objetivo do projeto é permitir que técnicos e gestores tomem decisões baseadas em dados concretos 📊.

A API é responsável por acessar o banco de dados e disponibilizar as informações de forma segura, utilizando criptografia simétrica para garantir a proteção dos dados.

## 🤔 Por quê existe este projeto?

Este projeto faz parte do nosso Trabalho de Conclusão de Curso (TCC), intitulado "Solução Eficiente e Sustentável: Microsserviços, Dashboards e TV Box na Modernização da Gestão na Assistência Social", disponível em [IFSP Pergamum](https://ifsp.pergamum.com.br/acervo/97902).

A API SVSA Dashboard será utilizada pela Secretaria de Cidadania e Ação Social da Estância Turística de Salto como um complemento do SVSA (Sistema de Vigilância Socioassistencial)

O projeto adota uma abordagem moderna e sustentável, utilizando microsserviços, criptografia simétrica e computação em nuvem para otimizar a gestão socioassistencial.

Se tiver algum feedback, sugestão ou melhoria, ficaremos felizes em recebê-los! 🚀

Entre em contato por e-mail: correa.joaov25@gmail.com

Além disso, você pode utilizar este projeto para estudos, aprimoramento ou até mesmo para inspirar novas soluções!💡

## 🔍 Algumas Observações sobre esta API

1 - Esta API foi desenvolvida para ser executada em um servidor web. O Tomcat está configurado como provided, ou seja, deve ser provido externamente.

Caso queira testar a API localmente com o Tomcat embutido, remova ou comente a seguinte dependência no pom.xml:

```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
      <scope>provided</scope>
    </dependency>
```

2 - Seus endpoints retornam apenas Strings criptografadas, ou seja, estudem bem o código e utilizem uma chave secreta simétrica de 128 bits. 

## ⚙️ Instalação

[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - para instalar o Java 17.

[Tomcat 11](https://tomcat.apache.org/download-11.cgi) (opcional, caso queira executar a API manualmente em um servidor externo)

**Recomendação**: Utilize um Tomcat externo na versão 10 ou posterior para evitar erros de incompatibilidade com o Spring.

## 🛠️ Funcionalidades

- Units
  - Consultar unidades ativas que tenham atendimentos realizados e situações de violência registradas.

- AssistanceTypes
  - Consultar a quantidade de atendimentos realizados por tipos de atendimentos em cada uma das unidades ativas.

- ViolenceSituationsTypes
  - Consultar a quantidade de situações de violência registradas por tipos em cada uma das unidades ativas.

## 🔑 Endpoints

- Consultar unidades ativas que tenham atendimentos realizados e situações de violência registradas.
    ```
    GET /units
    ```
    Retorna uma lista de unidades ativas criptografadas.


- Consultar a quantidade de atendimentos realizados por tipos de atendimentos em cada uma das unidades ativas.
    ```
    GET /assistanceTypes?year=?
    ```
    Retorna a quantidade de atendimentos realizados por tipos de atendimentos em cada uma das unidades ativas e criptografadas. Existe o parâmetro '_year_' (ano), ele é opcional. Se informado (year=2024), a consulta retorna os atendimentos realizados no ano especificado. Se omitido, a consulta considera todos os registros disponíveis na base.


- Consultar a quantidade de situações de violência registradas por tipos em cada uma das unidades ativas.
    ```
    GET /violenceSituationsTypes?year=?
    ```
    Retorna a quantidade de situações de violência registradas por tipos em cada uma das unidades ativas e criptografadas. Existe o parâmetro '_year_' (ano), ele é opcional. Se informado (year=2024), a consulta retorna os atendimentos realizados no ano especificado. Se omitido, a consulta considera todos os registros disponíveis na base.

## 🚀 Getting Started

### 🧑‍💻 Pré requisitos

Para rodar esse proejto em modo de desenvolvimento, você precisarpa de um ambiente básico para executar uma aplicação Java-Spring, o qual pode ser encontrado [aqui](https://www.java.com/en/download/help/windows_manual_download.html)

### 📂 Clonando

```
$ git clone https://github.com/JoaoVictorCorrea/api-svsa-dashboard

$ cd api-svsa-dashboard
```

### ⚙️ Empacotando com Maven ###

```
$ mvn clear

$ mvn package
```

### 🚀 Executando em um Servidor Tomcat externo

1 - Obtenha o arquivo .war gerado pelo Maven após o empacotamento, localizado na pasta ```/target``` do seu projeto.

2 - Coloque o arquivo .war na pasta ```webapps``` do servidor Tomcat.

3 - Para que a API funcione corretamente, crie um arquivo chamado ```setenv.bat``` na pasta ```bin``` do Tomcat. Este arquivo será responsável por definir as variáveis de ambiente necessárias. O conteúdo do arquivo deve ser o seguinte:

```
  set SECRET_KEY=<SUA CHAVE SECRETA>
  set DATABASE_URL=<SUA URL DO BANCO (NESSE CASO COM MYSQL)>
  set DATABASE_USERNAME=<SEU USERNAME DO BANCO>
  set DATABASE_PASSWORD=<SUA SENHA DO BANCO>
```

**Observação**: Substitua os valores ```<SUA CHAVE SECRETA>```, ```<SUA URL DO BANCO (MYSQL)>```, ```<SEU USERNAME DO BANCO>``` e ```<SUA SENHA DO BANCO>``` pelas informações correspondentes ao seu ambiente.

## 🔧Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.0
- Spring Web
- Spring Validation
- Spring DevTools
- MySQL Connector 8.0.33
- Jackson
- Maven
    
## 🤝 Contribuindo

Você pode enviar quantos PRs quiser, ficaremos felizes em analisá-los e aceitá-los! E se tiver alguma dúvida sobre o projeto...

Me envie um email: correa.joaov25@gmail.com

Conecte-se conosco [LinkedIn André](https://www.linkedin.com/in/andre-franco07/) e [LinkedIn João](https://www.linkedin.com/in/joaovcorrea/)

Obrigado! 😉
