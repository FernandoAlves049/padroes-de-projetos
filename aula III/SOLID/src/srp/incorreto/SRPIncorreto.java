package srp.incorreto;

/**
 * =====================================================
 * PRINCÍPIO: Single Responsibility Principle (SRP)
 * STATUS: INCORRETO - VIOLA O PRINCÍPIO
 * =====================================================
 *
 * PROBLEMA:
 * A classe "Funcionario" possui MÚLTIPLAS responsabilidades:
 * 1. Gerenciar dados do funcionário (nome, salário)
 * 2. Calcular o salário
 * 3. Gerar relatório em texto
 * 4. Salvar no banco de dados
 *
 * Isso viola o SRP porque a classe tem mais de uma razão para mudar:
 * - Se a lógica de cálculo mudar, mexemos aqui.
 * - Se o formato do relatório mudar, mexemos aqui.
 * - Se o banco de dados mudar, mexemos aqui.
 *
 * UMA CLASSE DEVE TER APENAS UMA RAZÃO PARA MUDAR.
 */
public class SRPIncorreto {

    // Classe que faz TUDO: viola o SRP
    static class Funcionario {
        private String nome;
        private double salarioBase;
        private String cargo;

        public Funcionario(String nome, double salarioBase, String cargo) {
            this.nome = nome;
            this.salarioBase = salarioBase;
            this.cargo = cargo;
        }

        // Responsabilidade 1: dados do funcionário - OK
        public String getNome() {
            return nome;
        }

        // ❌ Responsabilidade 2: cálculo de salário
        public double calcularSalarioLiquido() {
            double inss = salarioBase * 0.11;
            double irrf = salarioBase * 0.15;
            return salarioBase - inss - irrf;
        }

        // ❌ Responsabilidade 3: geração de relatório
        public String gerarRelatorio() {
            return "=== RELATÓRIO DO FUNCIONÁRIO ===\n" +
                    "Nome: " + nome + "\n" +
                    "Cargo: " + cargo + "\n" +
                    "Salário Base: R$ " + salarioBase + "\n" +
                    "Salário Líquido: R$ " + calcularSalarioLiquido() + "\n" +
                    "================================";
        }

        // ❌ Responsabilidade 4: persistência no banco de dados
        public void salvarNoBancoDeDados() {
            System.out.println("[DB] Conectando ao banco de dados...");
            System.out.println("[DB] Salvando funcionário: " + nome);
            System.out.println("[DB] Operação INSERT executada com sucesso.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SRP - CÓDIGO INCORRETO ===");
        System.out.println("A classe Funcionario realiza 4 responsabilidades diferentes!\n");

        Funcionario f = new Funcionario("Carlos Souza", 5000.00, "Analista");

        System.out.println("Salário Líquido: R$ " + f.calcularSalarioLiquido());
        System.out.println();
        System.out.println(f.gerarRelatorio());
        System.out.println();
        f.salvarNoBancoDeDados();

        System.out.println("\n⚠  PROBLEMA: A classe Funcionario tem 4 motivos para mudar!");
        System.out.println("   - Mudar dados do funcionário");
        System.out.println("   - Mudar cálculo de impostos");
        System.out.println("   - Mudar formato do relatório");
        System.out.println("   - Mudar banco de dados");
    }
}
