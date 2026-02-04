# Projeto de Gestão de Funcionários e Autenticação

Este projeto é uma implementação em Java baseada em um diagrama UML discutido em sala de aula de Programação. Ele demonstra conceitos de Orientação a Objetos como herança, polimorfismo, classes abstratas e interfaces.

## Estrutura do Projeto

O código fonte está localizado na pasta `src/` e contém as seguintes principais estruturas:

### Interfaces
- **`Autenticavel`**: Define o contrato para classes que permitem login (`Diretor`, `Gerente`, `Cliente`).
- **`Departamento`**: Define métodos para gestão de departamentos.
- **`Fornecedor`**: Define métodos para gestão de fornecedores.

### Classes Abstratas
- **`Funcionario`**: Classe base para todos os tipos de funcionários. Contém atributos comuns como `nome` e `salarioBase` e o método abstrato `calcSalario()`.
- **`Pessoa`**: Classe base representando uma pessoa com dados como `nome`, `cpf`, `telefone` e `endereco`.

### Classes Concretas (Funcionários)
- **`Secretario`**: Funcionário com cálculo de salário padrão.
- **`Engenheiro`**: Funcionário com bonificação/comissão calculada sobre o salário.
- **`Diretor`**: Funcionário que também é `Autenticavel` (possui login).
- **`Gerente`**: Funcionário que também é `Autenticavel` (possui login).

### Outras Classes
- **`Cliente`**: Implementa `Autenticavel`, representando um usuário externo ao quadro de funcionários.
- **`App`**: Classe principal (`main`) que instancia os objetos e demonstra o funcionamento do sistema.

## Funcionalidades

O sistema permite:
1. Calcular salários de diferentes tipos de funcionários, aplicando regras específicas (ex: comissão para engenheiros).
2. Autenticar usuários (Diretores, Gerentes e Clientes) através de login e senha.
3. Gerenciar informações básicas de Pessoas, Departamentos e Fornecedores.

## Como Executar

1. Certifique-se de ter o Java (JDK) instalado.
2. Compile os arquivos na pasta `src`:
   ```bash
   javac -d bin src/*.java
   ```
3. Execute a classe principal:
   ```bash
   java -cp bin App
   ```

## Tecnologias Utilizadas
- Java
- Visual Studio Code

---
*Projeto desenvolvido para a disciplina de Padrões de Projeto.*
# padroes-de-projetos
