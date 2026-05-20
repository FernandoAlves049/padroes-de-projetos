import java.util.Scanner;

public class Interativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   LOJA DE QUADRINHOS - CAIXA ASSINATURA   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        while (continuar) {
            System.out.println("\n📦 Escolha um nível de assinatura:");
            System.out.println("1. Bronze (3 itens)");
            System.out.println("2. Prata (5 itens)");
            System.out.println("3. Ouro (7 itens)");
            System.out.println("4. Platina (10 itens)");
            System.out.println("5. Sair");
            System.out.print("\nOpção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            NivelCliente nivel = null;
            switch (opcao) {
                case 1:
                    nivel = NivelCliente.BRONZE;
                    break;
                case 2:
                    nivel = NivelCliente.PRATA;
                    break;
                case 3:
                    nivel = NivelCliente.OURO;
                    break;
                case 4:
                    nivel = NivelCliente.PLATINA;
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
                    continue;
            }

            if (nivel != null) {
                CaixaAssinatura caixa = new CaixaAssinatura(nivel);
                System.out.println();
                caixa.exibirConteudo();
            }
        }

        System.out.println("\n👋 Obrigado por usar nosso sistema!");
        scanner.close();
    }
}
