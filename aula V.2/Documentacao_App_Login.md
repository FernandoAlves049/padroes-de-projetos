# Sistema de Login - Padrão Singleton

## Link do Código (Repositório)

**GitHub**: [https://github.com/SeuUsuario/SistemaLoginSingleton](https://github.com/SeuUsuario/SistemaLoginSingleton)  
*(Lembre-se de substituir o link acima pelo link real do seu repositório no Github após realizar o push do seu código)*

---

## Diagrama de Classes (Estrutural)

Abaixo está o diagrama de classes da aplicação, detalhando os atributos, métodos e demonstrando a estrutura do padrão de projeto em evidência (**Singleton**).

```mermaid
classDiagram
    %% Estilização para o padrão Singleton
    class Login {
        <<Singleton>>
        -static Login instancia
        -String usuario
        -String senha
        -Login()
        +static getInstancia() Login
        +gerarCodigoVerificador() String
        +autenticar(usuarioDigitado: String, senhaDigitada: String, codigoDigitado: String, codigoGerado: String) boolean
        +getUsuario() String
        +setUsuario(usuario: String) void
        +getSenha() String
        +setSenha(senha: String) void
    }

    class App {
        +static main(args: String[]) void
    }

    App ..> Login : Solicita Instância Mestra
```

---

## Diagrama de Sequência (Comportamental)

Abaixo apresentamos o fluxo de interação e o processo de verificação antibot no momento do Login. É um excelente complemento para entender o papel de cada parte da aplicação em tempo de execução.

```mermaid
sequenceDiagram
    actor Usuario
    participant App
    participant Login as Login (Singleton)

    App->>Login: Login.getInstancia()
    Login-->>App: retorna instancia única
    
    Usuario->>App: Digita "usuario" e "senha"
    
    App->>Login: gerarCodigoVerificador()
    Login-->>App: retorna "codigoGerado"
    
    App->>Usuario: Exibe desafio Anti-Bot (codigo)
    Usuario->>App: Digita "codigoDigitado"
    
    App->>Login: autenticar(user, pass, codDigitado, codGerado)
    
    alt Credenciais e Captcha corretos
        Login-->>App: retorna true
        App->>Usuario: Exibe "Acesso concedido" e mensagem de bem-vindo
    else Credenciais ou Captcha incorretos
        Login-->>App: retorna false
        App->>Usuario: Exibe "Acesso negado" e mensagem de erro
    end
```

---

## Como Exportar este arquivo para PDF no VS Code

1. Instale a extensão chamada **Markdown PDF** no seu Visual Studio Code (caso ainda não tenha).
2. Clique com o botão direito em qualquer lugar deste arquivo aberto e selecione **"Markdown PDF: Export (pdf)"**.
3. O arquivo PDF será gerado automaticamente na mesma pasta.
