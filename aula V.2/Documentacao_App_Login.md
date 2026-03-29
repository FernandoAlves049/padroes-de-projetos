# Sistema de Login - Padrão Singleton

## Link do Código (Repositório)

**GitHub**: [https://github.com/SeuUsuario/SistemaLoginSingleton](https://github.com/SeuUsuario/SistemaLoginSingleton)  
*(Lembre-se de substituir o link acima pelo link real do seu repositório no Github após realizar o push do seu código)*

---

## Diagrama UML

Abaixo está o diagrama de classes da aplicação, demonstrando a estrutura do padrão de projeto Singleton.

```mermaid
classDiagram
    class Login {
        - static Login instancia
        - String usuario
        - String senha
        - Login()
        + static Login getInstancia()
        + String gerarCodigoVerificador()
        + boolean autenticar(String usuarioDigitado, String senhaDigitada, String codigoDigitado, String codigoGerado)
        + String getUsuario()
        + void setUsuario(String usuario)
        + String getSenha()
        + void setSenha(String senha)
    }

    class App {
        + static void main(String[] args)
    }

    App ..> Login : uses
```

## Como Exportar este arquivo para PDF no VS Code

1. Instale a extensão chamada **Markdown PDF** no seu Visual Studio Code (caso ainda não tenha).
2. Clique com o botão direito em qualquer lugar deste arquivo aberto e selecione **"Markdown PDF: Export (pdf)"**.
3. O arquivo PDF será gerado automaticamente na mesma pasta.
