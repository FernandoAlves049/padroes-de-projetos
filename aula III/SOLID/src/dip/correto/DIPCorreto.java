package dip.correto;

/**
 * =====================================================
 * PRINCÍPIO: Dependency Inversion Principle (DIP)
 * STATUS: CORRETO - SEGUE O PRINCÍPIO
 * =====================================================
 *
 * SOLUÇÃO:
 * Criamos ABSTRAÇÕES (interfaces) para banco de dados e notificação.
 * A classe Pedido agora depende das interfaces — não das implementações.
 *
 * Para trocar MySQL por PostgreSQL, ou Email por SMS:
 * → Basta criar uma nova classe que implemente a interface.
 * → A classe Pedido não precisa mudar!
 */
public class DIPCorreto {

    // ✅ Abstração para persistência
    interface BancoDeDados {
        void salvar(String dados);
    }

    // ✅ Abstração para notificação
    interface Notificacao {
        void enviar(String mensagem);
    }

    // ✅ Implementações concretas de baixo nível

    static class MySQLConexao implements BancoDeDados {
        @Override
        public void salvar(String dados) {
            System.out.println("[MySQL] Salvando: " + dados);
        }
    }

    static class PostgreSQLConexao implements BancoDeDados {
        @Override
        public void salvar(String dados) {
            System.out.println("[PostgreSQL] Salvando: " + dados);
        }
    }

    static class EmailNotificacao implements Notificacao {
        @Override
        public void enviar(String mensagem) {
            System.out.println("[Email] Enviando: " + mensagem);
        }
    }

    static class SMSNotificacao implements Notificacao {
        @Override
        public void enviar(String mensagem) {
            System.out.println("[SMS] Enviando: " + mensagem);
        }
    }

    // ✅ Módulo de ALTO NÍVEL depende de ABSTRAÇÕES!
    static class Pedido {
        private BancoDeDados banco;
        private Notificacao notificacao;

        // ✅ Injeção de dependência via construtor
        public Pedido(BancoDeDados banco, Notificacao notificacao) {
            this.banco = banco;
            this.notificacao = notificacao;
        }

        public void realizarPedido(String produto) {
            System.out.println("Processando pedido: " + produto);
            banco.salvar("Pedido: " + produto);
            notificacao.enviar("Seu pedido de '" + produto + "' foi confirmado!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DIP - CÓDIGO CORRETO ===");
        System.out.println("Pedido depende de interfaces, não de classes concretas!\n");

        System.out.println("--- Cenário 1: MySQL + Email ---");
        Pedido pedido1 = new Pedido(new MySQLConexao(), new EmailNotificacao());
        pedido1.realizarPedido("Notebook Dell");

        System.out.println();
        System.out.println("--- Cenário 2: PostgreSQL + SMS (sem modificar Pedido!) ---");
        Pedido pedido2 = new Pedido(new PostgreSQLConexao(), new SMSNotificacao());
        pedido2.realizarPedido("Monitor LG");

        System.out.println("\n✅ CORRETO: A classe Pedido não foi modificada!");
        System.out.println("   Trocamos MySQL por PostgreSQL e Email por SMS,");
        System.out.println("   apenas passando implementações diferentes.");
    }
}
