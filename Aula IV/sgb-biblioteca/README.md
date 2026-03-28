# 📚 Sistema de Gestão de Biblioteca (SGB)

Este projeto é uma aplicação de console em Java desenvolvida para exercitar a aplicação dos padrões de projeto **MVC (Model-View-Controller)**, **DAO (Data Access Object)** e **BO (Business Object)**.

O sistema gerencia livros e empréstimos, garantindo a consistência das regras de negócio e a organização das camadas para futura escalabilidade (como a troca de persistência em memória por um banco de dados real).

---

## 🏗️ Arquitetura do Projeto

A estrutura foi dividida em pacotes seguindo as melhores práticas:

- **Model**: Entidades puras (`Livro`, `Emprestimo`) com atributos e getters/setters.
- **DAO (Data Access Object)**:
  - `LivroDAO` / `EmprestimoDAO` (Interfaces): Definem as assinaturas dos métodos de acesso a dados.
  - `MemoryDAO` (Implementações): Simulam o banco de dados utilizando listas estáticas em memória.
- **BO (Business Object)**: Onde as regras de negócio residem. Validações de cadastro, regras de disponibilidade e o desafio técnico.
- **Controller**: Intermediário que gerencia o fluxo entre a View e o BO, tratando exceções e formatando respostas.
- **View**: Interface de usuário via console (`MenuConsole`) que interage com o usuário final.

---

## 🚀 Funcionalidades

1. **Cadastrar Livro**: Permite registrar livros com ID autogerado.
2. **Listar Livros**: Opções para ver todos os livros ou apenas os disponíveis.
3. **Realizar Empréstimo**: Verifica disponibilidade do livro e registra o leitor.
4. **Devolver Livro**: Atualiza o status do livro para disponível.
5. **Excluir Livro (Desafio)**: Impede a exclusão de livros que possuam empréstimos ativos.

---

## 🛠️ Como Executar

### Pré-requisitos

- Java 8 ou superior (OpenJDK 19 recomendado).
- Apache Maven instalado.

### Comandos

1. **Compilar o projeto**:

    ```bash
    mvn compile
    ```

2. **Rodar o sistema**:

    ```bash
    mvn exec:java -Dexec.mainClass="br.edu.ifgoiano.view.MenuConsole"
    ```

---

## 📝 Relatório Técnico (Questões da Atividade)

### ❓ Questão 1: Se a regra de exclusão fosse colocada no DAO, o que aconteceria se mudássemos o banco de dados?

**Resposta**: Teríamos um problema de manutenção e redundância. O DAO (Data Access Object) deve ser agnóstico a regras de negócio e focar apenas em *como* salvar os dados. Se a regra estivesse no DAO, ao trocarmos de um banco em memória para SQL, teríamos que implementar a mesma lógica de validação novamente no novo DAO, violando o princípio **DRY (Don't Repeat Yourself)**.

### ❓ Questão 2: Se fosse no Controller, como faríamos se criássemos uma versão Web depois?

**Resposta**: O Controller é responsável pelo controle de fluxo de uma interface específica. Se a lógica estivesse no Controller de Console, ao criar uma versão Web ou Mobile, seríamos obrigados a duplicar essa lógica em cada novo controlador de interface. Ao usar a camada **BO (Business Object)**, garantimos que todas as interfaces consumam a mesma regra centralizada, facilitando a reutilização do código.

---

## 👥 Autores

- [Fernando Alves de Sousa]
- [Nome do Colega 2]
- [Nome do Colega 3]

---
*Atividade Prática de Programação - 5º Período - IF Goiano*
