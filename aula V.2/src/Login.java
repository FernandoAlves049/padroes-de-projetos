import java.util.Random;

public class Login {
    private static Login instancia;
    private String usuario;
    private String senha;

    // Construtor privado para impedir instanciação externa
    private Login() {
        this.usuario = "admin";
        this.senha = "12345";
    }

    // Método público estático que retorna a única instância da classe
    public static Login getInstancia() {
        if (instancia == null) {
            instancia = new Login();
        }
        return instancia;
    }

    // Gera um código de verificação (Captcha) com números e símbolos aleatórios
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

    // Método para autenticar o usuário
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

    // Getters and Setters (opcionais, caso queira mudar o usuário/senha padrão)
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
