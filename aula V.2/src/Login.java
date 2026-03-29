import java.util.Random;

public class Login {
    private static Login instancia;
    private String usuario;
    private String senha;

    private Login() {
        this.usuario = "admin";
        this.senha = "12345";
    }
    public static Login getInstancia() {
        if (instancia == null) {
            instancia = new Login();
        }
        return instancia;
    }

    public String gerarCodigoVerificador() {
        String caracteres = "0123456789!@#$%&*+?";
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }

    public boolean autenticar(String usuarioDigitado, String senhaDigitada, String codigoDigitado, String codigoGerado) {
        if (!this.usuario.equals(usuarioDigitado) || !this.senha.equals(senhaDigitada)) {
            System.out.println("Erro: Usuário ou senha incorretos.");
            return false;
        }

        if (!codigoGerado.equals(codigoDigitado)) {
            System.out.println("Erro: Código de verificação de bot incorreto.");
            return false;
        }

        System.out.println("Sucesso: Login realizado com sucesso!");
        return true;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
