package isp.incorreto;

/**
 * =====================================================
 * PRINCÍPIO: Interface Segregation Principle (ISP)
 * STATUS: INCORRETO - VIOLA O PRINCÍPIO
 * =====================================================
 *
 * PROBLEMA:
 * A interface "Trabalhador" é muito grande e obriga classes que não
 * precisam de certos métodos a implementá-los mesmo assim.
 *
 * VIOLAÇÃO:
 * Um Estagiário não pode gerenciar projetos, mas é FORÇADO a
 * implementar gerenciarProjeto() por causa da interface "gorda".
 *
 * "Clientes não devem ser forçados a depender de métodos que não usam."
 */
public class ISPIncorreto {

    // ❌ Interface "gorda" com muitas responsabilidades misturadas
    interface Trabalhador {
        void trabalhar();

        void receberSalario();

        void gerenciarProjeto(); // ❌ Apenas gerentes fazem isso!

        void contratarFuncionario(); // ❌ Apenas gerentes fazem isso!

        void fazerHorasExtras();
    }

    // ❌ Gerente — usa todos os métodos
    static class Gerente implements Trabalhador {
        private String nome;

        public Gerente(String nome) {
            this.nome = nome;
        }

        @Override
        public void trabalhar() {
            System.out.println(nome + " gerencia a equipe.");
        }

        @Override
        public void receberSalario() {
            System.out.println(nome + " recebe salário.");
        }

        @Override
        public void gerenciarProjeto() {
            System.out.println(nome + " gerencia o projeto.");
        }

        @Override
        public void contratarFuncionario() {
            System.out.println(nome + " contrata funcionários.");
        }

        @Override
        public void fazerHorasExtras() {
            System.out.println(nome + " faz horas extras.");
        }
    }

    // ❌ Estagiário — FORÇADO a implementar métodos que não fazem sentido!
    static class Estagiario implements Trabalhador {
        private String nome;

        public Estagiario(String nome) {
            this.nome = nome;
        }

        @Override
        public void trabalhar() {
            System.out.println(nome + " realiza tarefas básicas.");
        }

        @Override
        public void receberSalario() {
            System.out.println(nome + " recebe bolsa-auxílio.");
        }

        @Override
        public void fazerHorasExtras() {
            System.out.println(nome + " faz horas extras.");
        }

        // ❌ Não faz sentido! Forçado pela interface "gorda".
        @Override
        public void gerenciarProjeto() {
            throw new UnsupportedOperationException("Estagiário não pode gerenciar projetos!");
        }

        @Override
        public void contratarFuncionario() {
            throw new UnsupportedOperationException("Estagiário não pode contratar!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ISP - CÓDIGO INCORRETO ===");
        System.out.println("Estagiário forçado a implementar métodos que não usa!\n");

        Gerente gerente = new Gerente("Ana Lima");
        gerente.trabalhar();
        gerente.gerenciarProjeto();

        System.out.println();
        Estagiario estagiario = new Estagiario("Pedro Costa");
        estagiario.trabalhar();

        System.out.println();
        System.out.println("⚠  Tentando chamar gerenciarProjeto() no Estagiário:");
        try {
            estagiario.gerenciarProjeto(); // ❌ Explode em tempo de execução!
        } catch (UnsupportedOperationException e) {
            System.out.println("   ERRO: " + e.getMessage());
        }

        System.out.println("\n⚠  PROBLEMA: Estagiário implementa interface com métodos");
        System.out.println("   que não fazem sentido para ele. Viola o ISP!");
    }
}
