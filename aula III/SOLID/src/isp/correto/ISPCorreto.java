package isp.correto;

/**
 * =====================================================
 * PRINCÍPIO: Interface Segregation Principle (ISP)
 * STATUS: CORRETO - SEGUE O PRINCÍPIO
 * =====================================================
 *
 * SOLUÇÃO:
 * Quebramos a interface "gorda" em interfaces menores e coesas.
 * Cada classe implementa apenas as interfaces que realmente usa.
 *
 * - ITrabalhador → qualquer trabalhador
 * - IFazHorasExtras → trabalhadores que podem fazer horas extras
 * - IGerente → responsabilidades exclusivas de gerentes
 */
public class ISPCorreto {

    // ✅ Interfaces pequenas e coesas
    interface ITrabalhador {
        void trabalhar();

        void receberSalario();
    }

    interface IFazHorasExtras {
        void fazerHorasExtras();
    }

    interface IGerente {
        void gerenciarProjeto();

        void contratarFuncionario();
    }

    // ✅ Gerente implementa TODAS as interfaces, pois usa todas
    static class Gerente implements ITrabalhador, IFazHorasExtras, IGerente {
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
        public void fazerHorasExtras() {
            System.out.println(nome + " faz horas extras.");
        }

        @Override
        public void gerenciarProjeto() {
            System.out.println(nome + " gerencia o projeto.");
        }

        @Override
        public void contratarFuncionario() {
            System.out.println(nome + " contrata funcionários.");
        }
    }

    // ✅ Estagiário implementa apenas o que faz sentido para ele
    static class Estagiario implements ITrabalhador {
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
        // ✅ Não é forçado a implementar gerenciarProjeto() nem contratarFuncionario()
    }

    // ✅ Freelancer: trabalha e faz horas extras, mas não é gerente
    static class Freelancer implements ITrabalhador, IFazHorasExtras {
        private String nome;

        public Freelancer(String nome) {
            this.nome = nome;
        }

        @Override
        public void trabalhar() {
            System.out.println(nome + " entrega projetos autônomos.");
        }

        @Override
        public void receberSalario() {
            System.out.println(nome + " recebe por projeto concluído.");
        }

        @Override
        public void fazerHorasExtras() {
            System.out.println(nome + " faz horas extras se necessário.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ISP - CÓDIGO CORRETO ===");
        System.out.println("Cada classe implementa apenas as interfaces que fazem sentido!\n");

        Gerente gerente = new Gerente("Ana Lima");
        gerente.trabalhar();
        gerente.gerenciarProjeto();
        gerente.contratarFuncionario();

        System.out.println();
        Estagiario estagiario = new Estagiario("Pedro Costa");
        estagiario.trabalhar();
        estagiario.receberSalario();
        // ✅ Não existe gerenciarProjeto() — não é forçado!

        System.out.println();
        Freelancer freelancer = new Freelancer("Maria Oliveira");
        freelancer.trabalhar();
        freelancer.fazerHorasExtras();

        System.out.println("\n✅ CORRETO: Interfaces segregadas por responsabilidade.");
        System.out.println("   Nenhuma classe implementa método que não usa!");
    }
}
