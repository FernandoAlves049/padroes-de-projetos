import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            imprimirCabecalho();
            imprimirMenu();

            String entrada = scanner.nextLine().trim();
            switch (entrada) {
                case "1":
                    imprimirCaixaSelecionada(NivelCliente.BRONZE);
                    pausar(scanner);
                    break;
                case "2":
                    imprimirCaixaSelecionada(NivelCliente.PRATA);
                    pausar(scanner);
                    break;
                case "3":
                    imprimirCaixaSelecionada(NivelCliente.OURO);
                    pausar(scanner);
                    break;
                case "4":
                    imprimirCaixaSelecionada(NivelCliente.PLATINA);
                    pausar(scanner);
                    break;
                case "5":
                    imprimirCaixas();
                    imprimirResumoFinal();
                    pausar(scanner);
                    break;
                case "0":
                    executando = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida. Tente novamente.");
                    pausar(scanner);
                    break;
            }

            limparTela();
        }

        scanner.close();
    }

    private static void imprimirCabecalho() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   LOJA DE QUADRINHOS - CAIXA ASSINATURA   ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Execução completa do sistema");
        System.out.println("- Cada caixa é gerada aleatoriamente");
        System.out.println("- Itens repetidos são permitidos");
        System.out.println("- O total é calculado automaticamente");
        System.out.println();
    }

    private static void imprimirMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Gerar caixa Bronze");
        System.out.println("2 - Gerar caixa Prata");
        System.out.println("3 - Gerar caixa Ouro");
        System.out.println("4 - Gerar caixa Platina");
        System.out.println("5 - Executar tudo de uma vez");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void imprimirCaixas() {
        for (NivelCliente nivel : NivelCliente.values()) {
            CaixaAssinatura caixa = new CaixaAssinatura(nivel);
            imprimirCaixa(caixa);
            System.out.println();
        }
    }

    private static void imprimirCaixaSelecionada(NivelCliente nivel) {
        CaixaAssinatura caixa = new CaixaAssinatura(nivel);
        imprimirCaixa(caixa);
        System.out.println();
    }

    private static void imprimirCaixa(CaixaAssinatura caixa) {
        List<Item> itens = caixa.getItens();

        System.out.println("======================================");
        System.out.println("NÍVEL: " + caixa.getNivel());
        System.out.println("QUANTIDADE DE ITENS: " + itens.size());
        System.out.println("======================================");

        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            System.out.println(String.format(Locale.forLanguageTag("pt-BR"), "%2d. %-15s %s", i + 1, item.getNome(), item.formatarPreco()));
        }

        System.out.println("--------------------------------------");
        System.out.println(String.format(Locale.forLanguageTag("pt-BR"), "VALOR TOTAL: R$ %.2f", caixa.getValorTotal()));
    }

    private static void imprimirResumoFinal() {
        System.out.println();
        System.out.println("Resumo dos níveis:");
        for (NivelCliente nivel : NivelCliente.values()) {
            System.out.println("- " + nivel + ": " + nivel.getQuantidadeItens() + " itens");
        }
        System.out.println();
        System.out.println("Execução concluída com sucesso.");
    }

    private static void pausar(Scanner scanner) {
        System.out.println();
        System.out.println("Pressione Enter para voltar ao menu...");
        scanner.nextLine();
    }

    private static void limparTela() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
