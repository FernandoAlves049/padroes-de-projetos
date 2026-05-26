import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Assinatura assinatura = new AssinaturaBase();
        Set<Integer> pacotesEscolhidos = new HashSet<>();

        boolean executando = true;
        while (executando) {
            System.out.println("Sistema de assinatura de streaming");
            System.out.println();
            System.out.println("Assinatura atual: " + assinatura.getDescricao() + " - " + formatarPreco(assinatura.getPreco()));
            System.out.println();
            System.out.println("Pacotes opcionais:");
            System.out.println("1 - Assistir vídeos em vários dispositivos - " + formatarPreco(19.99));
            System.out.println("2 - Frete grátis em produtos - " + formatarPreco(9.99));
            System.out.println("3 - Caixa surpresa com produtos relacionados a filmes e séries - " + formatarPreco(29.99));
            System.out.println("4 - Cartão de crédito Platinum - " + formatarPreco(49.99));
            System.out.println("5 - Compra com Cash Back - " + formatarPreco(19.99));
            System.out.println("6 - Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                continue;
            }

            int opcao;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                System.out.println();
                continue;
            }

            if (opcao == 6) {
                executando = false;
                continue;
            }

            if (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida.");
                System.out.println();
                continue;
            }

            if (pacotesEscolhidos.add(opcao)) {
                assinatura = adicionarPacote(assinatura, opcao);
                System.out.println("Pacote adicionado com sucesso.");
            } else {
                System.out.println("Esse pacote já foi adicionado e será ignorado.");
            }

            System.out.println();
            System.out.println("Resumo da assinatura:");
            System.out.println(assinatura.getDescricao());
            System.out.println("Total: " + formatarPreco(assinatura.getPreco()));
            System.out.println();
        }

        System.out.println();
        System.out.println("Assinatura final:");
        System.out.println(assinatura.getDescricao());
        System.out.println("Total final: " + formatarPreco(assinatura.getPreco()));

        scanner.close();
    }

    private static Assinatura adicionarPacote(Assinatura assinatura, int numeroPacote) {
        switch (numeroPacote) {
            case 1:
                return new PacoteVariosDispositivos(assinatura);
            case 2:
                return new PacoteFreteGratis(assinatura);
            case 3:
                return new PacoteCaixaSurpresa(assinatura);
            case 4:
                return new PacoteCartaoPlatinum(assinatura);
            case 5:
                return new PacoteCashBack(assinatura);
            default:
                return assinatura;
        }
    }

    private static String formatarPreco(double valor) {
        return "R$" + String.format(Locale.US, "%.2f", valor).replace('.', ',');
    }
}
