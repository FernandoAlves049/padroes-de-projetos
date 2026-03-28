# Walkthrough - Sistema de Gestão de Biblioteca (SGB)

Foi implementado com sucesso o sistema de gestão de biblioteca seguindo as arquiteturas MVC, DAO e BO em Java.

## Estrutura do Projeto

O projeto está dividido nos seguintes pacotes, garantindo a separação de responsabilidades:

- **`br.edu.ifgoiano.model`**: Contém as classes `Livro` e `Emprestimo` (Entidades POJO).
- **`br.edu.ifgoiano.dao`**: Interfaces e classes de acesso a dados em memória (`LivroMemoryDAO`, `EmprestimoMemoryDAO`).
- **`br.edu.ifgoiano.bo`**: Classes de lógica de negócio (`LivroBO`, `EmprestimoBO`), incluindo validações e a regra de desafio.
- **`br.edu.ifgoiano.controller`**: Controlador único `BibliotecaController` para gerenciar a interação entre View e Negócio.
- **`br.edu.ifgoiano.view`**: Interface de console em `MenuConsole`.

## Funcionalidades Implementadas

1.  **Cadastro de Livros**: Validação de título e autor não vazios.
2.  **Listagem**: Visualização de todos os livros e apenas os disponíveis.
3.  **Realização de Empréstimo**: Verifica existência do livro, disponibilidade e troca o status do livro para "Emprestado".
4.  **Devolução de Livro**: Torna o livro disponível novamente.
5.  **Desafio - Exclusão de Livros**: Implementada regra no `LivroBO` que impede a exclusão de um livro se ele estiver emprestado.

## Respostas ao Relatório de Entrega

> [!NOTE]
> **Questão 1: Se essa regra (exclusão de livro) fosse colocada no DAO, o que aconteceria se mudássemos o banco de dados?**
>
> Se a regra estivesse no DAO, cada nova implementação de persistência (ex: SQL, NoSQL, Arquivo) teria que conter a mesma lógica duplicada. Isso tornaria a manutenção difícil e o sistema propenso a falhas, pois uma mudança na regra de negócio exigiria alteração em todos os DAOs em vez de apenas um lugar central.

> [!NOTE]
> **Questão 2: Se fosse no Controller, como faríamos se criássemos uma versão Web (Interface Gráfica) depois?**
>
> Ao colocar a lógica no Controller, restringimos a regra de negócio a uma interface específica. Se fosse criada uma versão Web, teríamos que copiar a lógica para o novo Controller da Web. Com a lógica no **BO (Business Object)**, todas as interfaces (Console, Web, App Mobile) consomem a mesma regra de negócio partindo de uma única fonte da verdade.

## Demonstração do Código

O menu principal oferece as seguintes opções:

```text
=== Sistema de Gestão de Biblioteca (SGB) ===
1. Cadastrar Livro
2. Listar Livros Disponíveis
3. Realizar Empréstimo
4. Devolver Livro
5. Listar Todos os Livros
6. Excluir Livro (Desafio)
0. Sair
```

### Exemplo de Fluxo:
- Cadastrar Livro "Java Puro" -> Listar (Disponível).
- Realizar Empréstimo -> Status muda para "Emprestado".
- Tentar Excluir (Opção 6) -> Sistema retorna erro: "Não é possível excluir um livro que está emprestado!".
- Devolver Livro -> Status volta para "Disponível".
- Tentar Excluir novamente -> Sucesso.

---
**Status da Entrega**: Sistema rodando via console sem erros de compilação.
