# 📚 Padrões de Projetos — 5º Período

Bem-vindo(a)! Este repositório foi criado para armazenar e organizar todas as atividades e trabalhos acadêmicos desenvolvidos durante a disciplina de **Padrões de Projetos** no Instituto Federal.

## 🚀 Objetivo

Documentar o progresso e aprendizado ao longo do semestre, servindo como portfólio das soluções implementadas para os problemas propostos em aula, desde fundamentos de OO até padrões de projeto clássicos GoF (SOLID, MVC, DAO, Singleton, Builder, Prototype).

---

## 📂 Estrutura do Repositório

| Pasta | Tema | Padrão / Conceito |
|---|---|---|
| [`aula II/`](./aula%20II/) | Fundamentos de OO | Herança, Polimorfismo, Interfaces, Classes Abstratas |
| [`aula III/SOLID/`](./aula%20III/SOLID/) | Princípios SOLID | SRP, OCP, LSP, ISP, DIP |
| [`Aula IV/sgb-biblioteca/`](./Aula%20IV/sgb-biblioteca/) | Sistema de Biblioteca | MVC, DAO (Data Access Object), BO (Business Object) |
| [`aula V/`](./aula%20V/) | Sistema de Login | Padrão Singleton |
| [`aula V.2/`](./aula%20V.2/) | Sistema de Login (Singleton) | Singleton + Captcha Anti-Bot |
| [`aula V.3/`](./aula%20V.3/) | Singleton com MultiThreads | Singleton Thread-Safe + Concorrência |
| [`aula VIII/Sistema de Montagem de Veículos/`](./aula%20VIII/Sistema%20de%20Montagem%20de%20Ve%C3%ADculos/) | Fábrica de Veículos | Builder Clássico GoF (Director + ConcreteBuilders) |
| [`aula VIII/Sistema de Configuração de Notebook/`](./aula%20VIII/Sistema%20de%20Configura%C3%A7%C3%A3o%20de%20Notebook/) | Configuração de Notebooks | Builder com Fluent Interface + Herança + Imutabilidade |
| [`Aula IX/`](./Aula%20IX/) | Fábrica de Violões | Prototype (Clonagem Superficial e Profunda) |

---

## 📖 Detalhes de Cada Aula

### 📗 Aula II — Fundamentos de OO (Herança, Polimorfismo e Interfaces)

Implementação de um sistema de gestão de pessoas (Funcionários, Clientes, Fornecedores) com foco nos pilares da Programação Orientada a Objetos.

**Conceitos abordados:**

- Herança e Polimorfismo
- Classes Abstratas (`Pessoa`, `Funcionario`)
- Interfaces de comportamento: `Autenticavel`, `Departamento`, `Fornecedor`
- Hierarquia de classes: `Gerente`, `Diretor`, `Engenheiro`, `Secretario`, `Cliente`

---

### 📘 Aula III — Princípios SOLID

Demonstração interativa dos 5 princípios SOLID, com exemplos de código **incorreto vs. correto** para cada princípio, incluindo uma **Interface Gráfica** (`javax.swing`) com tema escuro.

| Letra | Princípio | Frase-chave |
|---|---|---|
| **S** | Single Responsibility | Uma classe = uma responsabilidade |
| **O** | Open/Closed | Aberto para extensão, fechado para modificação |
| **L** | Liskov Substitution | Subtipos devem substituir seus tipos base sem quebras |
| **I** | Interface Segregation | Interfaces pequenas e coesas, sem métodos desnecessários |
| **D** | Dependency Inversion | Dependa de abstrações, não de implementações concretas |

---

### 📙 Aula IV — Sistema de Gestão de Biblioteca (MVC + DAO + BO)

Aplicação de console em Java para gerenciamento de livros e empréstimos, seguindo a arquitetura em camadas **MVC**, **DAO** e **BO**.

**Funcionalidades:**

- Cadastro e listagem de livros
- Realização e devolução de empréstimos
- Exclusão segura (impede remoção de livros com empréstimos ativos)

**Tecnologias:** Java + Apache Maven

---

### 📕 Aula V / V.2 — Sistema de Login (Padrão Singleton)

Sistema de autenticação implementado com o padrão de projeto **Singleton**, garantindo que exista apenas uma instância do gerenciador de login na aplicação.

**Funcionalidades:**

- Validação de credenciais (usuário e senha)
- Verificador Anti-Bot (Captcha) com código alfanumérico aleatório gerado a cada tentativa
- Documentação UML e diagrama de classes

---

### 🔴 Aula V.3 — Singleton com MultiThreads (Thread-Safe)

Simulação de acesso concorrente a um banco de dados utilizando o padrão **Singleton thread-safe**. O projeto demonstra que múltiplas threads simultâneas compartilham a mesma instância do gerenciador de conexão, identificada pelo mesmo hash.

**Conceitos abordados:**

- Singleton com `synchronized` / double-checked locking para segurança em ambientes multi-thread
- Criação e execução de múltiplas threads (`Thread` / `Runnable`)
- Verificação de instância única via `hashCode()`

**Classes:**

- `DatabaseConnectionManager` — Singleton thread-safe do gerenciador de conexão
- `DatabaseAccessThread` — Thread que solicita acesso ao banco
- `App` — Ponto de entrada; cria e executa 5+ threads simultâneas

---

### 🔧 Aula VIII — Padrão Builder

Dois projetos distintos que exploram diferentes variações do padrão criacional **Builder**:

#### 🚗 Sistema de Montagem de Veículos (Builder Clássico GoF)

Projeto que aplica o Builder clássico da GoF para montar três tipos de veículos (Carro, Caminhão e Moto) seguindo uma sequência fixa de etapas: Motor → Transmissão → Pintura → Rodas.

**Participantes:**

| Papel | Classe |
|---|---|
| Produto | `Veiculo` |
| Interface Builder | `VeiculoBuilder` |
| Builder Base | `VeiculoBuilderBase` |
| Builders Concretos | `CarroBuilder`, `CaminhaoBuilder`, `MotoBuilder` |
| Director | `DiretorMontagem` |
| Client | `App` |

#### 💻 Sistema de Configuração de Notebooks (Builder com Fluent Interface)

Projeto que monta notebooks personalizados usando **Builder com Fluent Interface**, **Herança**, **Inner Class** e **Imutabilidade**. Os componentes configuráveis são: Processador, Memória RAM, Armazenamento, Placa de Vídeo e Sistema Operacional.

**Tipos de Notebook:**

- `NotebookGamer` — alto desempenho (ex.: Intel i7, RTX 4060, 32GB DDR5)
- `NotebookTrabalho` — uso profissional (ex.: AMD Ryzen 7, Radeon integrada, Ubuntu)

---

### 🎸 Aula IX — Fábrica de Violões (Padrão Prototype)

Implementação do **Padrão Prototype** em Java com duas aplicações distintas que demonstram as diferenças práticas entre clonagem superficial e profunda.

**9 tipos de violão implementados:**

| Tipo | Cordas | Material | Elétrico | Nível |
|---|---|---|---|---|
| Clássico | 6 | Nylon | Não | Iniciante |
| Folk | 6 | Aço | Sim | Intermediário |
| Flet | 6 | Nylon | Sim | Profissional |
| Jumbo | 6 | Aço | Sim | Intermediário |
| 7 Cordas | 7 | Nylon | Não | Intermediário |
| 12 Cordas | 12 | Aço | Não | Profissional |
| Zero (Parlor) | 6 | Nylon | Não | Iniciante |
| Duplo Zero | 6 | Aço | Não | Iniciante |
| Triplo Zero | 6 | Nylon | Não | Iniciante |

**Comparativo de clonagem:**

| Aspecto | Superficial | Profunda |
|---|---|---|
| Mecanismo | `super.clone()` | `super.clone()` + construtor de cópia |
| Campos primitivos | ✅ Copiados | ✅ Copiados |
| Objetos internos | ⚠️ Mesma referência | ✅ Nova instância |
| Risco de efeito colateral | ⚠️ Alto | ✅ Nenhum |

**Participantes:**

| Papel | Classe(s) |
|---|---|
| Prototype | `Violao` (método `clone()`) |
| ConcretePrototype | `ViolaoClassico`, `ViolaoFolk`, `ViolaoFlet`, etc. |
| Registry | `FabricaDeVioloes` |
| Client | `MainSuperficial` / `MainProfunda` |

---

## 🛠️ Tecnologias

- **Java** — Linguagem principal
- **Apache Maven** — Gerenciamento de dependências (Aula IV)
- **javax.swing** — Interface gráfica (Aula III)
- **Mermaid / Draw.io** — Diagramas UML

---

## 📌 Status

🚧 Em desenvolvimento constante ao longo do semestre. 🚧

---

*Repositório acadêmico — Disciplina de Padrões de Projeto — IF Goiano, 5º Período.*
