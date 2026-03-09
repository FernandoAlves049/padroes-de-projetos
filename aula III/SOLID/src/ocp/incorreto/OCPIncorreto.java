package ocp.incorreto;

/**
 * =====================================================
 * PRINCÍPIO: Open/Closed Principle (OCP)
 * STATUS: INCORRETO - VIOLA O PRINCÍPIO
 * =====================================================
 *
 * PROBLEMA:
 * A classe "CalculadoraDesconto" usa um bloco if/else gigante para
 * determinar o desconto por tipo de cliente.
 *
 * VIOLAÇÃO:
 * Para adicionar um NOVO tipo de cliente (ex: "VIP"), é necessário
 * MODIFICAR a classe existente, o que viola o OCP.
 *
 * O PRINCÍPIO DITA:
 * "Aberto para extensão, fechado para modificação."
 */
public class OCPIncorreto {

    static class CalculadoraDesconto {

        // ❌ Para cada novo tipo de cliente, este método precisa ser MODIFICADO
        public double calcularDesconto(String tipoCliente, double valorCompra) {
            if (tipoCliente.equals("COMUM")) {
                return valorCompra * 0.05;
            } else if (tipoCliente.equals("PREMIUM")) {
                return valorCompra * 0.10;
            } else if (tipoCliente.equals("OURO")) {
                return valorCompra * 0.20;
            }
            // ❌ Para adicionar "VIP" temos que mexer aqui dentro!
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== OCP - CÓDIGO INCORRETO ===");
        System.out.println("Para adicionar novo tipo de cliente, MODIFICA-SE a classe existente!\n");

        CalculadoraDesconto calc = new CalculadoraDesconto();
        double valor = 500.00;

        System.out.printf("Cliente COMUM   → Desconto: R$ %.2f%n", calc.calcularDesconto("COMUM", valor));
        System.out.printf("Cliente PREMIUM → Desconto: R$ %.2f%n", calc.calcularDesconto("PREMIUM", valor));
        System.out.printf("Cliente OURO    → Desconto: R$ %.2f%n", calc.calcularDesconto("OURO", valor));

        System.out.println("\n⚠  PROBLEMA: Para adicionar tipo 'VIP' com 30%,");
        System.out.println("   PRECISAMOS modificar o método calcularDesconto().");
        System.out.println("   Isso pode introduzir bugs em código que já funcionava!");
    }
}
