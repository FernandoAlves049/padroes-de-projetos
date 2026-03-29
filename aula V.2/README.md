# Sistema de Login (Padrão Singleton)

Este é um projeto simples em Java que simula um sistema de autenticação, aplicando o padrão de projeto **Singleton**. O programa foi desenvolvido como exercício para a disciplina de Padrões de Projeto.

## 📋 Funcionalidades

- **Autenticação de Usuário**: Validação básica de credenciais (Usuário e Senha).
- **Verificador Anti-Bot (Captcha)**: Geração de um código aleatório (contendo números e símbolos) a cada tentativa de login, exigindo que o usuário digite o código corretamente para prosseguir.
- **Instância Única**: A classe de **Login** foi implementada usando o padrão **Singleton**, garantindo que exista apenas uma instância do gerenciador de autenticação no sistema.

## 💻 Tecnologias Utilizadas

- **Linguagem**: Java
- **Conceitos abordados**: Padrão de Projeto Criacional (Singleton), POO e Entrada de dados via console.

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado no seu computador.
2. Clone o repositório ou baixe os arquivos fonte.
3. Abra um terminal na pasta raiz do projeto.
4. Compile os arquivos Java usando o seguinte comando:

   ```bash
   javac src/Login.java src/App.java
   ```

5. Execute a classe principal `App` com o comando:

   ```bash
   java -cp src App
   ```

## 📄 Documentação e UML

O diagrama de classes e a documentação do projeto, contendo o fluxo dependente do Singleton, podem ser encontrados no arquivo [`Documentacao_App_Login.md`](./Documentacao_App_Login.md) que também foi exportado com sucesso para um documento PDF na raiz deste projeto.

---

> Desenvolvido para apresentar a utilização prática de Design Patterns estruturados com Java.
