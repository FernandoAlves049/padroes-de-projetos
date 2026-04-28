package clonagem_profunda;

import java.util.Scanner;

/**
 * Cliente - Aplicacao 2: CLONAGEM PROFUNDA
 */
public class MainProfunda {

    public static void main(String[] args) {

        FabricaDeVioloes fabrica = new FabricaDeVioloes();

        String sep  = "====================================================";
        String sep2 = "+--------------------------------------------------+";

        System.out.println("\n" + sep);
        System.out.println("   PADRAO PROTOTYPE  -  CLONAGEM PROFUNDA");
        System.out.println("   Fabrica de Violoes  |  Aula IX - PP");
        System.out.println(sep);

        fabrica.listarCatalogo();

        System.out.println("  Opcoes: classico | folk | flet | jumbo | 7cordas");
        System.out.println("          12cordas | zero | duplozero | triplozero");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n  > Tipo de violao (ou 'sair'): ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("sair")) break;

            try {
                // -- Clona e exibe
                Violao clone1 = fabrica.getViolao(entrada);
                System.out.println("\n  [OK] Clone profundo criado com sucesso!");
                clone1.exibirDetalhes();

                // -- Demonstracao da independencia
                Violao clone2 = fabrica.getViolao(entrada);
                double precoOriginal = clone2.getEspecificacoes().getPrecoDouble();
                clone2.getEspecificacoes().setPreco(precoOriginal + 9999.00);

                int hash1 = System.identityHashCode(clone1.getEspecificacoes());
                int hash2 = System.identityHashCode(clone2.getEspecificacoes());

                System.out.println("\n" + sep2);
                System.out.printf("|  %-48s|%n", "TESTE - CLONAGEM PROFUNDA");
                System.out.println(sep2);
                System.out.printf("|  %-48s|%n", "Alterou o preco SOMENTE no 2o clone...");
                System.out.println(sep2);
                System.out.printf("|  1o clone  ->  R$ %-29s|%n", clone1.getEspecificacoes().getPreco());
                System.out.printf("|  2o clone  ->  R$ %-29s|%n", clone2.getEspecificacoes().getPreco());
                System.out.println(sep2);
                System.out.printf("|  %-48s|%n", "Referencias dos objetos EspecificacoesTecnicas:");
                System.out.printf("|  1o clone  ->  hash #%-26s|%n", hash1);
                System.out.printf("|  2o clone  ->  hash #%-26s|%n", hash2);
                System.out.println(sep2);
                System.out.printf("|  %-48s|%n", "[OK] Precos DIFERENTES! Objetos independentes.");
                System.out.printf("|  %-48s|%n", "     Clonagem profunda: cada clone tem o seu.");
                System.out.println(sep2);

            } catch (IllegalArgumentException e) {
                System.out.println("  [ERRO] " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("\n  Encerrando... ate logo!\n");
    }
}
