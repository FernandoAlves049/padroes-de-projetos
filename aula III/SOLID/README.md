# 📐 Princípios SOLID em Java — Demonstração Interativa

> Projeto acadêmico para a disciplina de **Padrões de Projeto — Instituto Federal (4º Período)**

Este repositório contém uma implementação completa e didática dos **5 princípios SOLID** aplicados em Java.
Cada princípio possui **dois exemplos lado a lado**: o código que **viola** o princípio (`incorreto/`) e a **solução correta** (`correto/`), permitindo comparação direta do impacto de um bom design orientado a objetos.

O projeto inclui uma **Interface Gráfica (GUI)** construída com `javax.swing` para facilitar a execução e visualização das demonstrações, além de um executor via **linha de comando** (`App.java`).

---

## 🎥 Vídeo de Apresentação

No vídeo abaixo, demonstramos o funcionamento prático de cada princípio pela nossa Interface Gráfica e explicamos o impacto de um design de código bem estruturado.

> **[📺 CLIQUE AQUI PARA ASSISTIR AO VÍDEO]( INSIRA_O_LINK_DO_VÍDEO_AQUI )**

---

## 📁 Estrutura do Projeto

```text
SOLID/
├── README.md                          ← Este arquivo
├── drawio_diagrams.txt                ← Diagramas UML (Mermaid) para importar no Draw.io
└── src/
    ├── App.java                       ← Executor via Terminal (todos os princípios)
    ├── GUIApp.java                    ← Interface Gráfica Interativa (javax.swing)
    │
    ├── srp/                           ← Single Responsibility Principle
    │   ├── incorreto/
    │   │   └── SRPIncorreto.java
    │   └── correto/
    │       └── SRPCorreto.java
    │
    ├── ocp/                           ← Open/Closed Principle
    │   ├── incorreto/
    │   │   └── OCPIncorreto.java
    │   └── correto/
    │       └── OCPCorreto.java
    │
    ├── lsp/                           ← Liskov Substitution Principle
    │   ├── incorreto/
    │   │   └── LSPIncorreto.java
    │   └── correto/
    │       └── LSPCorreto.java
    │
    ├── isp/                           ← Interface Segregation Principle
    │   ├── incorreto/
    │   │   └── ISPIncorreto.java
    │   └── correto/
    │       └── ISPCorreto.java
    │
    └── dip/                           ← Dependency Inversion Principle
        ├── incorreto/
        │   └── DIPIncorreto.java
        └── correto/
            └── DIPCorreto.java
```

> Cada princípio segue o padrão de pacotes Java: `srp.incorreto`, `srp.correto`, `ocp.incorreto`, etc.

---

## 💻 Interface Gráfica (GUI)

A GUI foi construída com `javax.swing` e oferece uma experiência interativa com tema escuro. Ao executar `GUIApp.java`, você tem acesso a:

| Botão | Cor | Função |
| --- | --- | --- |
| **SRP** | 🔵 Azul | Executa exemplos do Single Responsibility Principle |
| **OCP** | 🟣 Roxo | Executa exemplos do Open/Closed Principle |
| **LSP** | 🟠 Laranja | Executa exemplos do Liskov Substitution Principle |
| **ISP** | 🔵 Ciano | Executa exemplos do Interface Segregation Principle |
| **DIP** | 🩷 Rosa | Executa exemplos do Dependency Inversion Principle |
| **TODOS** | 🟢 Verde | Executa todos os 5 princípios de uma vez |
| **Explicar Princípios** | 🟧 Laranja escuro | Exibe explicação teórica detalhada de cada princípio |
| **Limpar Terminal** | 🔴 Vermelho | Limpa a área de saída |

**Características técnicas:**
- O `System.out` é redirecionado para um `JTextArea` com tema escuro (fundo `#1E1E1E`, texto claro, fonte `Monospaced 14pt`)
- Cada execução roda em uma `SwingWorker` para não travar a interface
- Janela de 950×650px, centralizada na tela

---

## 📘 Os 5 Princípios SOLID — Explicação Detalhada

### S — Single Responsibility Principle (SRP)

> *"Uma classe deve ter apenas uma razão para mudar."*

| Cenário | Pacote | O que acontece |
| --- | --- | --- |
| ❌ **Incorreto** | `srp.incorreto` | A classe `Funcionario` acumula **4 responsabilidades**: armazenar dados do funcionário, calcular impostos/salário líquido, gerar relatório formatado e salvar no banco de dados. Qualquer alteração em uma dessas áreas obriga a mexer na mesma classe. |
| ✅ **Correto** | `srp.correto` | As responsabilidades foram separadas em **4 classes**: `Funcionario` (apenas dados: nome, cargo, salário), `CalculadoraSalario` (cálculo de impostos e salário líquido), `RelatorioFuncionario` (formatação de relatórios) e `FuncionarioRepositorio` (simulação de persistência no banco). |

**Classes do exemplo correto:**
- `Funcionario` — armazena `nome`, `cargo` e `salarioBase`
- `CalculadoraSalario` — calcula `salarioLiquido(Funcionario)`
- `RelatorioFuncionario` — gera `relatorio(Funcionario, salarioLiquido)`
- `FuncionarioRepositorio` — `salvarNoBanco(Funcionario)`

---

### O — Open/Closed Principle (OCP)

> *"Entidades de software devem ser abertas para extensão, mas fechadas para modificação."*

| Cenário | Pacote | O que acontece |
| --- | --- | --- |
| ❌ **Incorreto** | `ocp.incorreto` | A `CalculadoraDesconto` usa uma cadeia de `if/else` baseada em `String tipoCliente`. Para adicionar um novo tipo de cliente (ex.: VIP), é necessário **modificar a classe existente**, adicionando mais um `if`. |
| ✅ **Correto** | `ocp.correto` | Criamos a interface `Desconto` com os métodos `calcular(double)` e `getTipoCliente()`. Cada tipo de cliente é uma classe separada que implementa essa interface. A `CalculadoraDesconto` recebe a abstração — **nunca precisa ser modificada** para novos tipos! |

**Classes do exemplo correto:**
- `Desconto` *(interface)* — contrato com `calcular()` e `getTipoCliente()`
- `DescontoComum` — desconto de 5%
- `DescontoPremium` — desconto de 10%
- `DescontoOuro` — desconto de 20%
- `DescontoVIP` — desconto de 30% *(adicionado sem modificar classes existentes!)*
- `CalculadoraDesconto` — delega o cálculo para a abstração

---

### L — Liskov Substitution Principle (LSP)

> *"Objetos de uma subclasse devem poder substituir objetos de sua superclasse sem quebrar o programa."*

| Cenário | Pacote | O que acontece |
| --- | --- | --- |
| ❌ **Incorreto** | `lsp.incorreto` | `Quadrado` herda de `Retangulo`. Porém, quando se altera a largura do quadrado, a altura muda junto (e vice-versa), quebrando o cálculo de área esperado para retângulos. A substituição viola o contrato da classe base. |
| ✅ **Correto** | `lsp.correto` | Criamos a interface `Forma` com o método `getArea()`. Tanto `Retangulo`, `Quadrado` quanto `Circulo` são entidades **independentes** que implementam o mesmo contrato, sem herança perigosa. |

**Classes do exemplo correto:**
- `Forma` *(interface)* — contrato com `getArea()`
- `Retangulo` — atributos `largura` e `altura`
- `Quadrado` — atributo `lado`
- `Circulo` — atributo `raio`

---

### I — Interface Segregation Principle (ISP)

> *"Clientes não devem ser forçados a depender de métodos que não usam."*

| Cenário | Pacote | O que acontece |
| --- | --- | --- |
| ❌ **Incorreto** | `isp.incorreto` | A interface `Trabalhador` define `trabalhar()`, `receberSalario()` e `gerenciarProjeto()`. A classe `Estagiario` é **forçada** a implementar `gerenciarProjeto()`, mesmo sem ter essa responsabilidade, gerando código morto e exceções. |
| ✅ **Correto** | `isp.correto` | A interface foi **segregada** em 3 interfaces coesas: `ITrabalhador` (trabalhar, receber salário), `IFazHorasExtras` (horas extras) e `IGerente` (gerenciar projeto, contratar funcionário). Cada classe implementa **apenas** o que faz sentido para ela. |

**Classes do exemplo correto:**
- `ITrabalhador` *(interface)* — `trabalhar()`, `receberSalario()`
- `IFazHorasExtras` *(interface)* — `fazerHorasExtras()`
- `IGerente` *(interface)* — `gerenciarProjeto()`, `contratarFuncionario()`
- `Gerente` — implementa `ITrabalhador` + `IFazHorasExtras` + `IGerente`
- `Estagiario` — implementa **apenas** `ITrabalhador` *(sem métodos desnecessários!)*
- `Freelancer` — implementa `ITrabalhador` + `IFazHorasExtras` *(sem gerência!)*

---

### D — Dependency Inversion Principle (DIP)

> *"Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações."*

| Cenário | Pacote | O que acontece |
| --- | --- | --- |
| ❌ **Incorreto** | `dip.incorreto` | A classe `Pedido` cria internamente instâncias concretas de `MySQLConexao` e `EmailNotificacao`. Para trocar o banco ou o sistema de notificação, é preciso **modificar diretamente** a classe `Pedido`. |
| ✅ **Correto** | `dip.correto` | Criamos as interfaces `BancoDeDados` e `Notificacao`. A classe `Pedido` recebe as dependências via **injeção de dependência no construtor**. Para trocar MySQL por PostgreSQL ou Email por SMS, basta passar uma implementação diferente — **sem modificar `Pedido`!** |

**Classes do exemplo correto:**
- `BancoDeDados` *(interface)* — `salvar(String)`
- `Notificacao` *(interface)* — `enviar(String)`
- `MySQLConexao` — implementa `BancoDeDados`
- `PostgreSQLConexao` — implementa `BancoDeDados`
- `EmailNotificacao` — implementa `Notificacao`
- `SMSNotificacao` — implementa `Notificacao`
- `Pedido` — recebe `BancoDeDados` e `Notificacao` via construtor

---

## 📊 Diagramas UML

O arquivo `drawio_diagrams.txt` contém os diagramas de classes UML no formato **Mermaid** para todos os 5 princípios (exemplos incorretos e corretos lado a lado).

**Para visualizar os diagramas no Draw.io:**
1. Acesse [https://app.diagrams.net/](https://app.diagrams.net/)
2. Vá em **Organizar** → **Inserir** → **Avançado** → **Mermaid...**
3. Copie um bloco de código Mermaid do arquivo e cole na caixa de texto
4. Clique em **Inserir** para gerar o diagrama visual

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

- **Java JDK 11+** instalado (necessário para `String.repeat()` e recursos modernos)
- Terminal, PowerShell ou CMD

### Passo a Passo

**1. Clone o repositório e acesse a pasta `src/`:**

```bash
git clone <URL_DO_REPOSITÓRIO>
cd SOLID/src
```

**2. Compile todos os arquivos Java:**

```bash
javac *.java srp/**/*.java ocp/**/*.java lsp/**/*.java isp/**/*.java dip/**/*.java
```

**3. Execute a Interface Gráfica (Recomendado):**

```bash
java GUIApp
```

**4. Alternativa — Execute via Terminal (sem GUI):**

```bash
java App
```

> O `App.java` executa todos os 5 princípios em sequência, exibindo os logs no terminal.

---

## 🧠 Tecnologias Utilizadas

| Tecnologia | Uso |
| --- | --- |
| **Java** | Linguagem principal |
| **javax.swing** | Interface gráfica (GUI) |
| **SwingWorker** | Execução assíncrona na GUI |
| **Mermaid** | Diagramas UML de classes |
| **Draw.io** | Visualização dos diagramas |

---

## 📝 Resumo Rápido dos Princípios

| Letra | Princípio | Frase-chave |
| --- | --- | --- |
| **S** | Single Responsibility | Uma classe = uma responsabilidade |
| **O** | Open/Closed | Aberto para extensão, fechado para modificação |
| **L** | Liskov Substitution | Subtipos devem substituir seus tipos base sem quebras |
| **I** | Interface Segregation | Interfaces pequenas e coesas, sem métodos desnecessários |
| **D** | Dependency Inversion | Dependa de abstrações, não de implementações concretas |

---

## 👥 Integrantes do Grupo

> *(Adicione aqui os membros da equipe)*

- Membro 1
- Membro 2
- Membro 3

---

## 📚 Referências

- **Robert C. Martin** (Uncle Bob) — Autor primário das definições modernas do SOLID
- [Artigo original "Design Principles and Design Patterns" (2000)](https://web.archive.org/web/20150906155800/http://www.objectmentor.com/resources/articles/Principles_and_Patterns.pdf)
- [Clean Code: A Handbook of Agile Software Craftsmanship](https://www.amazon.com.br/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)

---

**Nota**: Trabalho acadêmico desenvolvido para a disciplina de Padrões de Projeto — Instituto Federal, 4º Período. Respeito irrestrito aos direitos intelectuais dos autores originais.
