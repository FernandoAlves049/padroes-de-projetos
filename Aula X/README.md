# 🔌 Multi-SGBD – Padrão Adapter

Implementação do **Padrão de Projeto Adapter** em Java utilizando Spring Boot para uma aplicação que suporta múltiplos Sistemas de Gerenciamento de Banco de Dados (SGBDs), desenvolvida como atividade da disciplina de Padrões de Projeto.

---

## 📐 Estrutura do Projeto

```text
Aula X/
├── sgbd-adapter/                  # Aplicação Spring Boot (Web)
│   ├── src/                       # Código-fonte principal
│   │   ├── main/java/br/com/adapter/
│   │   │   ├── adapter/           # Classes Adapter (Paradox, Firebird, MySQL)
│   │   │   ├── factory/           # Fábrica de Conexões
│   │   │   ├── controller/        # Controladores Web (Spring MVC)
│   │   │   ├── service/           # Regras de Negócio
│   │   │   └── ...
│   │   └── main/resources/        # Interface Gráfica (HTML, CSS)
│   ├── pom.xml                    # Dependências do Maven
│   └── README.md                  # Leia-me do subprojeto
└── README.md
```

---

## 🎯 Padrão Adapter

O **Adapter** é um padrão estrutural que permite a colaboração de objetos com interfaces incompatíveis. Neste projeto, ele é utilizado para padronizar o acesso a diferentes bancos de dados (Paradox, Firebird, MySQL) que possuem APIs distintas, expondo uma interface única para o cliente.

### Por que utilizar Spring Boot e uma Interface Web?

Decidi implementar esta atividade do **Padrão Adapter** utilizando o Spring Boot e uma interface gráfica Web em vez de uma aplicação tradicional em linha de comando (Console/Terminal).

Fiz essa escolha pelos seguintes motivos:

1. **Facilidade de Visualização**: A interface web (acessível pelo navegador) permite visualizar o Padrão Adapter em funcionamento de maneira muito mais clara e interativa. É possível trocar os "Perfis" clicando neles e ver imediatamente o resultado do Adapter correspondente sendo aplicado.
2. **Execução Simplificada**: Ao rodar a aplicação web, não é necessário compilar e rodar múltiplos comandos ou inspecionar textos longos no console. Basta acessar o navegador e testar os diferentes fluxos (Gratuito, Básico, Ultimate).
3. **Casos de Uso Reais**: Aplicações modernas frequentemente expõem padrões de projeto arquiteturais através de APIs REST. Utilizar o Spring Boot demonstra como o Padrão Adapter se integra perfeitamente a uma arquitetura Web real (Client -> Controller -> Service -> **Adapter** -> Adaptee).

Apesar da camada Web, o cerne do exercício — o Padrão Adapter — está implementado de forma pura e estrita dentro do pacote `br.com.adapter.adapter` e `br.com.adapter.factory`. O Spring Boot funciona apenas como o "Cliente" que consome essas interfaces.

---

## ▶️ Como Executar

1. Abra o terminal na pasta do subprojeto (`Aula X/sgbd-adapter`).
2. Execute o comando do Maven Wrapper para iniciar o Spring Boot:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

3. Abra o navegador e acesse: **<http://localhost:8080>**
