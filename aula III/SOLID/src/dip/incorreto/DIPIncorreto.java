package dip.incorreto;

/**
 * =====================================================
 * PRINCÍPIO: Dependency Inversion Principle (DIP)
 * STATUS: INCORRETO - VIOLA O PRINCÍPIO
 * =====================================================
 *
 * PROBLEMA:
 * A classe "Pedido" (módulo de alto nível) depende DIRETAMENTE de
 * classes concretas de baixo nível: MySQLConexao e EmailNotificacao.
 *
 * VIOLAÇÃO:
 * 1. Módulos de alto nível NÃO devem depender de módulos de baixo nível.
 * 2. Ambos devem depender de ABSTRAÇÕES (interfaces).
 *
 * Se trocarmos MySQL por PostgreSQL, temos que alterar a classe Pedido.
 */
public class DIPIncorreto {

    // ❌ Implementação concreta — baixo nível
    static class MySQLConexao {
        public void salvar(String dados) {
            System.out.println("[MySQL] Salvando: " + dados);
        }
    }

    // ❌ Implementação concreta — baixo nível
    static class EmailNotificacao {
        public void enviar(String mensagem) {
            System.out.println("[Email] Enviando: " + mensagem);
        }
    }

    // ❌ Módulo de ALTO NÍVEL dependendo diretamente de BAIXO NÍVEL!
    static class Pedido {
        private MySQLConexao banco = new MySQLConexao(); // ❌ acoplado ao MySQL
        private EmailNotificacao notificacao = new EmailNotificacao(); // ❌ acoplado ao Email

        public void realizarPedido(String produto) {
            System.out.println("Processando pedido: " + produto);
            banco.salvar("Pedido: " + produto);
            notificacao.enviar("Seu pedido de '" + produto + "' foi confirmado!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DIP - CÓDIGO INCORRETO ===");
        System.out.println("Pedido acoplado diretamente a MySQL e Email!\n");

        Pedido pedido = new Pedido();
        pedido.realizarPedido("Notebook Dell");

        System.out.println("\n⚠  PROBLEMA:");
        System.out.println("   Para usar PostgreSQL em vez de MySQL,");
        System.out.println("   precisamos MODIFICAR a classe Pedido!");
        System.out.println("   Para notificar por SMS, também precisamos modificar Pedido!");
    }
}
