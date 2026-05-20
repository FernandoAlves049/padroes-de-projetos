import java.util.List;

/**
 * Exemplos de uso do sistema de caixa de assinatura
 */
public class Exemplos {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║  EXEMPLOS DE USO - CAIXA DE ASSINATURA      ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        exemplo1_criacaoSimples();
        exemplo2_analiseDetalhada();
        exemplo3_comparacaoNiveis();
        exemplo4_processamentoCustomizado();
    }

    /**
     * Exemplo 1: Criação simples e exibição padrão
     */
    private static void exemplo1_criacaoSimples() {
        System.out.println("━━━ EXEMPLO 1: Criação Simples ━━━\n");

        CaixaAssinatura caixa = new CaixaAssinatura(NivelCliente.BRONZE);
        caixa.exibirConteudo();

        System.out.println("\n");
    }

    /**
     * Exemplo 2: Análise detalhada de uma caixa
     */
    private static void exemplo2_analiseDetalhada() {
        System.out.println("━━━ EXEMPLO 2: Análise Detalhada ━━━\n");

        CaixaAssinatura caixa = new CaixaAssinatura(NivelCliente.PRATA);

        System.out.println("Informações da Caixa:");
        System.out.println("  Nível: " + caixa.getNivel());
        System.out.println("  Total de itens: " + caixa.getItens().size());
        System.out.println("  Valor total: R$ " + String.format("%.2f", caixa.getValorTotal()));

        System.out.println("\nItens detalhados:");
        List<Item> itens = caixa.getItens();
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            System.out.printf("  %d. %-15s - R$ %.2f%n", i + 1, item.getNome(), item.getPreco());
        }

        // Contando ocorrências de cada tipo
        System.out.println("\nFrequência de tipos:");
        contarTipos(itens);

        System.out.println("\n");
    }

    /**
     * Exemplo 3: Comparação entre todos os níveis
     */
    private static void exemplo3_comparacaoNiveis() {
        System.out.println("━━━ EXEMPLO 3: Comparação Entre Níveis ━━━\n");

        System.out.printf("%-12s %-8s %-12s%n", "Nível", "Itens", "Valor Total");
        System.out.println("─".repeat(40));

        for (NivelCliente nivel : NivelCliente.values()) {
            CaixaAssinatura caixa = new CaixaAssinatura(nivel);
            System.out.printf("%-12s %-8d R$ %.2f%n", 
                nivel.toString(), 
                caixa.getItens().size(), 
                caixa.getValorTotal());
        }

        System.out.println("\n");
    }

    /**
     * Exemplo 4: Processamento customizado
     */
    private static void exemplo4_processamentoCustomizado() {
        System.out.println("━━━ EXEMPLO 4: Processamento Customizado ━━━\n");

        CaixaAssinatura caixa = new CaixaAssinatura(NivelCliente.OURO);
        List<Item> itens = caixa.getItens();

        // Separar itens por faixa de preço
        System.out.println("Itens por faixa de preço:\n");

        System.out.println("Itens de Luxo (≥ R$ 20,00):");
        for (Item item : itens) {
            if (item.getPreco() >= 20) {
                System.out.println("  • " + item);
            }
        }

        System.out.println("\nItens Intermediários (R$ 10,00 a R$ 19,99):");
        for (Item item : itens) {
            if (item.getPreco() >= 10 && item.getPreco() < 20) {
                System.out.println("  • " + item);
            }
        }

        System.out.println("\nItens Econômicos (< R$ 10,00):");
        for (Item item : itens) {
            if (item.getPreco() < 10) {
                System.out.println("  • " + item);
            }
        }

        // Calcular estatísticas
        System.out.println("\n\nEstatísticas da Caixa:");
        double preco_medio = caixa.getValorTotal() / itens.size();
        double preco_maximo = encontrarMaiorPreco(itens);
        double preco_minimo = encontrarMenorPreco(itens);

        System.out.printf("  Preço máximo: R$ %.2f%n", preco_maximo);
        System.out.printf("  Preço mínimo: R$ %.2f%n", preco_minimo);
        System.out.printf("  Preço médio: R$ %.2f%n", preco_medio);
        System.out.printf("  Valor total: R$ %.2f%n", caixa.getValorTotal());

        System.out.println("\n");
    }

    // Métodos auxiliares

    private static void contarTipos(List<Item> itens) {
        java.util.Map<String, Integer> frequencia = new java.util.HashMap<>();

        for (Item item : itens) {
            frequencia.put(item.getNome(), 
                frequencia.getOrDefault(item.getNome(), 0) + 1);
        }

        for (String tipo : frequencia.keySet()) {
            System.out.println("  " + tipo + ": " + frequencia.get(tipo) + "x");
        }
    }

    private static double encontrarMaiorPreco(List<Item> itens) {
        double maior = 0;
        for (Item item : itens) {
            if (item.getPreco() > maior) {
                maior = item.getPreco();
            }
        }
        return maior;
    }

    private static double encontrarMenorPreco(List<Item> itens) {
        double menor = Double.MAX_VALUE;
        for (Item item : itens) {
            if (item.getPreco() < menor) {
                menor = item.getPreco();
            }
        }
        return menor;
    }
}
