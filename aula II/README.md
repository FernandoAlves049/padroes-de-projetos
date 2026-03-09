# Aula II - Fundamentos de OO: Abstração, Polimorfismo e Interfaces

Este diretório contém a implementação de um sistema de gestão simples, desenvolvido para exercitar conceitos fundamentais da Programação Orientada a Objetos (POO).

## 🎯 Objetivos da Aula

- Compreender e aplicar **Herança** e **Polimorfismo**.
- Utilizar **Classes Abstratas** para definir modelos genéricos.
- Implementar **Interfaces** para contratos de comportamento (como autenticação e departamentos).
- Modelar relacionamentos entre classes representando Funcionários, Clientes e Fornecedores.

## 🏗️ Estrutura das Classes

### Hierarquia Principal
- **`Pessoa`**: Classe base abstrata contendo atributos comuns (`nome`, `documento`) para todos os indivíduos do sistema.
  - **`Funcionario`**: Classe abstrata que estende `Pessoa`. Define o contrato para cálculo de salário e comissão, além de implementar a interface `Departamento`.
    - **`Gerente`**: Implementação concreta de funcionário. É também `Autenticavel`.
    - **`Diretor`**: Implementação concreta de funcionário (cargo superior). É também `Autenticavel`.
    - **`Engenheiro`**: Implementação concreta de funcionário técnico.
    - **`Secretario`**: Implementação concreta de funcionário administrativo.
  - **`Cliente`**: Estende `Pessoa`. Representa um cliente externo que também pode atuar como `Fornecedor` e é `Autenticavel`.

### Interfaces (Contratos)
- **`Autenticavel`**: Define o método `login()`. Implementada por `Gerente`, `Diretor` e `Cliente`.
- **`Departamento`**: Define métodos para gestão de departamento (`getNomeDepartamento`, `setNomeDepartamento`). Obrigatória para `Funcionario`.
- **`Fornecedor`**: Define operações de fornecimento (`fornecerProdutos`, `emitirNotaFiscal`). Implementada por `Cliente`.

## 💻 Exemplo de Uso (Main)

A classe `Main.java` demonstra:
1. Instanciação de objetos (Diretores, Engenheiros, Clientes).
2. Uso de polimorfismo para tratar diferentes objetos (`Diretor`, `Cliente`) sob a mesma ótica da interface `Autenticavel`.
3. Chamada de métodos específicos definidos pelas interfaces implementadas.

## 🚀 Como Executar

1. Certifique-se de ter o Java instalado.
2. Navegue até o diretório `src`:
   ```bash
   cd "d:\if 4º periodo\padroes-de-projetos\aula II\src"
   ```
3. Compile os arquivos:
   ```bash
   javac *.java
   ```
4. Execute a classe principal:
   ```bash
   java Main
   ```

## 🛠️ Tecnologias
- Java
- Visual Studio Code

---
*Projeto desenvolvido para a disciplina de Padrões de Projeto - 5º Período.*