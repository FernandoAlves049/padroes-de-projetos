import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Obtém a instância Singleton da classe Login
        Login sistemaLogin = Login.getInstancia();

        System.out.println("Bem-vindo ao Sistema!");
        System.out.println("=== Tela de Login ===");

        // Solicita as credenciais ao usuário
        System.out.print("Digite o usuário: ");
        String usuarioDigitado = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senhaDigitada = scanner.nextLine();

        // Gera e exibe o código para verificação de bot
        String codigoGerado = sistemaLogin.gerarCodigoVerificador();
        System.out.println("\n[SISTEMA ANTI-BOT]");
        System.out.println("Para prosseguir, digite o seguinte código: " + codigoGerado);
        System.out.print("Código: ");
        String codigoDigitado = scanner.nextLine();

        // Tenta realizar a autenticação
        System.out.println("\nProcessando...");
        boolean sucesso = sistemaLogin.autenticar(usuarioDigitado, senhaDigitada, codigoDigitado, codigoGerado);

        if (sucesso) {
            System.out.println("Acesso concedido. Bem-vindo, " + sistemaLogin.getUsuario() + "!");
        } else {
            System.out.println("Acesso negado. Tente novamente.");
        }

        scanner.close();
    }
}
