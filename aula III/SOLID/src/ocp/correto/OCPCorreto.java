package ocp.correto;

/**
 * =====================================================
 * PRINCÍPIO: Open/Closed Principle (OCP)
 * STATUS: CORRETO - SEGUE O PRINCÍPIO
 * =====================================================
 *
 * SOLUÇÃO:
 * Criamos a interface "Desconto" como contrato.
 * Cada tipo de cliente implementa sua própria regra de desconto.
 *
 * Para adicionar um NOVO tipo, basta criar uma nova classe —
 * SEM MODIFICAR o código existente!
 */
public class OCPCorreto {

    // ✅ Contrato: qualquer desconto deve implementar esta interface
    interface Desconto {
        double calcular(double valorCompra);

        String getTipoCliente();
    }

    static class DescontoComum implements Desconto {
        @Override
        public double calcular(double v) {
            return v * 0.05;
        }

        @Override
        public String getTipoCliente() {
            return "COMUM";
        }
    }

    static class DescontoPremium implements Desconto {
        @Override
        public double calcular(double v) {
            return v * 0.10;
        }

        @Override
        public String getTipoCliente() {
            return "PREMIUM";
        }
    }

    static class DescontoOuro implements Desconto {
        @Override
        public double calcular(double v) {
            return v * 0.20;
        }

        @Override
        public String getTipoCliente() {
            return "OURO";
        }
    }

    // ✅ Novo tipo adicionado SEM modificar nenhuma classe existente!
    static class DescontoVIP implements Desconto {
        @Override
        public double calcular(double v) {
            return v * 0.30;
        }

        @Override
        public String getTipoCliente() {
            return "VIP";
        }
    }

    // ✅ Esta classe NUNCA precisa ser modificada para novos tipos!
    static class CalculadoraDesconto {
        public double calcularDesconto(Desconto desconto, double valorCompra) {
            return desconto.calcular(valorCompra);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== OCP - CÓDIGO CORRETO ===");
        System.out.println("Novo tipo de cliente → cria nova classe, sem modificar as existentes!\n");

        CalculadoraDesconto calc = new CalculadoraDesconto();
        double valor = 500.00;

        Desconto[] descontos = {
                new DescontoComum(),
                new DescontoPremium(),
                new DescontoOuro(),
                new DescontoVIP()
        };

        for (Desconto d : descontos) {
            System.out.printf("Cliente %-8s → Desconto: R$ %.2f%n",
                    d.getTipoCliente(), calc.calcularDesconto(d, valor));
        }

        System.out.println("\n✅ CORRETO: Para adicionar VIP, apenas criamos DescontoVIP.");
        System.out.println("   Nenhuma classe existente foi modificada!");
    }
}
