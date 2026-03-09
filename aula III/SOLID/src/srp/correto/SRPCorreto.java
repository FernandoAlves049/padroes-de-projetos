package srp.correto;

/**
 * =====================================================
 * PRINCÍPIO: Single Responsibility Principle (SRP)
 * STATUS: CORRETO - SEGUE O PRINCÍPIO
 * =====================================================
 *
 * SOLUÇÃO:
 * Separamos as responsabilidades em classes distintas:
 * 1. Funcionario → apenas dados do funcionário
 * 2. CalculadoraSalario → apenas cálculo de salário
 * 3. RelatorioFuncionario → apenas geração de relatório
 * 4. FuncionarioRepositorio → apenas persistência no banco
 *
 * Cada classe tem APENAS UMA razão para mudar.
 */
public class SRPCorreto {

    // ✅ Responsabilidade 1: apenas dados do funcionário
    static class Funcionario {
        private String nome;
        private double salarioBase;
        private String cargo;

        public Funcionario(String nome, double salarioBase, String cargo) {
            this.nome = nome;
            this.salarioBase = salarioBase;
            this.cargo = cargo;
        }

        public String getNome() {
            return nome;
        }

        public double getSalarioBase() {
            return salarioBase;
        }

        public String getCargo() {
            return cargo;
        }
    }

    // ✅ Responsabilidade 2: apenas cálculo de salário
    static class CalculadoraSalario {
        public double calcularLiquido(Funcionario f) {
            double inss = f.getSalarioBase() * 0.11;
            double irrf = f.getSalarioBase() * 0.15;
            return f.getSalarioBase() - inss - irrf;
        }
    }

    // ✅ Responsabilidade 3: apenas geração de relatório
    static class RelatorioFuncionario {
        private CalculadoraSalario calculadora = new CalculadoraSalario();

        public String gerar(Funcionario f) {
            return "=== RELATÓRIO DO FUNCIONÁRIO ===\n" +
                    "Nome: " + f.getNome() + "\n" +
                    "Cargo: " + f.getCargo() + "\n" +
                    "Salário Base: R$ " + f.getSalarioBase() + "\n" +
                    "Salário Líquido: R$ " + calculadora.calcularLiquido(f) + "\n" +
                    "================================";
        }
    }

    // ✅ Responsabilidade 4: apenas persistência no banco de dados
    static class FuncionarioRepositorio {
        public void salvar(Funcionario f) {
            System.out.println("[DB] Conectando ao banco de dados...");
            System.out.println("[DB] Salvando funcionário: " + f.getNome());
            System.out.println("[DB] Operação INSERT executada com sucesso.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SRP - CÓDIGO CORRETO ===");
        System.out.println("Cada classe tem apenas UMA responsabilidade!\n");

        Funcionario f = new Funcionario("Carlos Souza", 5000.00, "Analista");
        CalculadoraSalario calc = new CalculadoraSalario();
        RelatorioFuncionario rel = new RelatorioFuncionario();
        FuncionarioRepositorio repo = new FuncionarioRepositorio();

        System.out.println("Salário Líquido: R$ " + calc.calcularLiquido(f));
        System.out.println();
        System.out.println(rel.gerar(f));
        System.out.println();
        repo.salvar(f);

        System.out.println("\n✅ CORRETO: Cada classe tem apenas 1 motivo para mudar!");
        System.out.println("   - Funcionario: só muda se os dados do funcionário mudarem");
        System.out.println("   - CalculadoraSalario: só muda se as regras fiscais mudarem");
        System.out.println("   - RelatorioFuncionario: só muda se o formato do relatório mudar");
        System.out.println("   - FuncionarioRepositorio: só muda se o banco de dados mudar");
    }
}
