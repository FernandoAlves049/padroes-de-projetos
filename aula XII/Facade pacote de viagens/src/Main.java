import java.util.Scanner;

public class Main {
    private static ViagensFacade facade;
    private static Scanner scanner;

    public static void main(String[] args) {
        facade = new ViagensFacade();
        scanner = new Scanner(System.in);

        exibirMenuPrincipal();

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║   SISTEMA DE PACOTES DE VIAGENS            ║");
            System.out.println("║   Padrão Facade                            ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Fazer uma nova reserva");
            System.out.println("2. Ver disponibilidades");
            System.out.println("3. Executar testes automáticos");
            System.out.println("4. Sair");
            System.out.print("\nEscolha uma opção (1-4): ");

            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    processarNovaReserva();
                    break;
                case 2:
                    verDisponibilidades();
                    break;
                case 3:
                    executarTestes();
                    break;
                case 4:
                    executando = false;
                    System.out.println("\nObrigado por usar nossos serviços!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void executarTestes() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       EXECUTANDO TESTES AUTOMÁTICOS       ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        try {
            // Teste 1: PIX com desconto
            System.out.println("\n--- TESTE 1: Pagamento com PIX (Desconto 10%) ---");
            Reserva teste1 = facade.criarReserva();
            facade.adicionarComprador(teste1, "João Silva", "123.456.789-00");
            facade.adicionarComprador(teste1, "Maria Silva", "987.654.321-00");
            facade.reservarAssento(teste1, "5A");
            facade.reservarHotel(teste1, "Executivo", 2, 1, 3);
            facade.alugarCarro(teste1, "Econômico", 3);
            facade.definirFormaPagamento(teste1, "PIX", 1);
            facade.finalizarReserva(teste1, 2, 3);
            facade.exibirComprovanteReserva(teste1);

            // Teste 2: Crédito com juros
            System.out.println("\n--- TESTE 2: Pagamento em Crédito 3x (Juros) ---");
            Reserva teste2 = facade.criarReserva();
            facade.adicionarComprador(teste2, "Pedro Costa", "111.222.333-44");
            facade.reservarAssento(teste2, "15B");
            facade.reservarHotel(teste2, "Simples", 1, 1, 2);
            facade.alugarCarro(teste2, "Luxo", 2);
            facade.definirFormaPagamento(teste2, "Crédito", 3);
            facade.finalizarReserva(teste2, 1, 2);
            facade.exibirComprovanteReserva(teste2);

            // Teste 3: Boleto com desconto
            System.out.println("\n--- TESTE 3: Pagamento com Boleto (Desconto 5%) ---");
            Reserva teste3 = facade.criarReserva();
            facade.adicionarComprador(teste3, "Ana Santos", "555.666.777-88");
            facade.adicionarComprador(teste3, "Carlos Santos", "555.666.777-99");
            facade.reservarAssento(teste3, "1C");
            facade.reservarHotel(teste3, "Suite", 2, 1, 4);
            facade.alugarCarro(teste3, "Executiva", 4);
            facade.definirFormaPagamento(teste3, "Boleto", 1);
            facade.finalizarReserva(teste3, 2, 4);
            facade.exibirComprovanteReserva(teste3);

            System.out.println("\n✓ Testes concluídos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao executar testes: " + e.getMessage());
        }
    }

    private static void processarNovaReserva() {
        Reserva reserva = facade.criarReserva();

        // Coletar dados dos compradores
        System.out.print("\nQuantas pessoas estão fazendo esta reserva? ");
        int quantidadePessoas = lerInteiro();

        for (int i = 1; i <= quantidadePessoas; i++) {
            System.out.println("\n--- Dados da Pessoa " + i + " ---");
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine().trim();
            facade.adicionarComprador(reserva, nome, cpf);
        }

        // Reservar assento aéreo
        System.out.println("\n--- PASSAGEM AÉREA ---");
        selecionarAssento(reserva);

        // Reservar hotel
        System.out.println("\n--- HOTEL ---");
        selecionarHotel(reserva, quantidadePessoas);

        // Alugar carro
        System.out.println("\n--- ALUGUEL DE CARRO ---");
        selecionarCarro(reserva);

        // Forma de pagamento
        System.out.println("\n--- FORMA DE PAGAMENTO ---");
        selecionarPagamento(reserva);

        // Finalizar e exibir comprovante
        System.out.println("\n--- FINALIZANDO RESERVA ---");
        facade.finalizarReserva(reserva, quantidadePessoas, 
            Integer.parseInt(scanner.nextLine().trim().split(" ")[0]));
        facade.exibirComprovanteReserva(reserva);
    }

    private static void selecionarAssento(Reserva reserva) {
        System.out.println("\n=== ASSENTOS DISPONÍVEIS ===");
        facade.listarDisponibilidades();
        
        System.out.println("\n1. Assentos da 1ª Classe (R$ 3.125,00)");
        System.out.println("2. Assentos da Classe Executiva (R$ 1.250,00)");
        System.out.println("3. Assentos da Classe Econômica (R$ 500,00)");
        System.out.print("Escolha a classe (1-3): ");
        int classe = lerInteiro();

        System.out.print("Digite o número do assento (ex: 1A, 5B): ");
        String assento = scanner.nextLine().trim().toUpperCase();

        if (facade.reservarAssento(reserva, assento)) {
            System.out.println("✓ Assento " + assento + " reservado com sucesso!");
        } else {
            System.out.println("✗ Assento não disponível!");
        }
    }

    private static void selecionarHotel(Reserva reserva, int quantidadePessoas) {
        System.out.println("\n1. Simples (R$ 200,00/pessoa/dia)");
        System.out.println("2. Executivo (R$ 500,00/pessoa/dia)");
        System.out.println("3. Suite Presidencial (R$ 2.000,00/pessoa/dia)");
        System.out.print("Escolha o tipo de quarto (1-3): ");
        
        int opcao = lerInteiro();
        String tipoQuarto = "";
        
        switch(opcao) {
            case 1:
                tipoQuarto = "Simples";
                break;
            case 2:
                tipoQuarto = "Executivo";
                break;
            case 3:
                tipoQuarto = "Suite";
                break;
        }

        System.out.print("Quantos dias de hospedagem? ");
        int diasHotel = lerInteiro();

        if (facade.reservarHotel(reserva, tipoQuarto, quantidadePessoas, 1, diasHotel)) {
            System.out.println("✓ Hotel " + tipoQuarto + " por " + diasHotel + " dias reservado!");
        } else {
            System.out.println("✗ Erro na reserva do hotel!");
        }
    }

    private static void selecionarCarro(Reserva reserva) {
        System.out.println("\n1. Econômico (R$ 150,00/dia)");
        System.out.println("2. Executivo (R$ 300,00/dia)");
        System.out.println("3. Luxo (R$ 600,00/dia)");
        System.out.print("Escolha o tipo de carro (1-3): ");
        
        int opcao = lerInteiro();
        String tipoCarro = "";
        
        switch(opcao) {
            case 1:
                tipoCarro = "Economica";
                break;
            case 2:
                tipoCarro = "Executiva";
                break;
            case 3:
                tipoCarro = "Luxo";
                break;
        }

        System.out.print("Quantos dias de aluguel? ");
        int diasCarro = lerInteiro();

        if (facade.alugarCarro(reserva, tipoCarro, diasCarro)) {
            System.out.println("✓ Carro " + tipoCarro + " por " + diasCarro + " dias alugado!");
        } else {
            System.out.println("✗ Erro no aluguel do carro!");
        }
    }

    private static void selecionarPagamento(Reserva reserva) {
        System.out.println("\n1. PIX (10% de desconto)");
        System.out.println("2. Boleto (5% de desconto)");
        System.out.println("3. Débito (sem juros/descontos)");
        System.out.println("4. Crédito (até 6 parcelas com 3,99% juros)");
        System.out.print("Escolha a forma de pagamento (1-4): ");

        int opcaoPagamento = lerInteiro();
        String metodoPagamento = "";
        int parcelas = 1;

        switch (opcaoPagamento) {
            case 1:
                metodoPagamento = "PIX";
                break;
            case 2:
                metodoPagamento = "Boleto";
                break;
            case 3:
                metodoPagamento = "Débito";
                break;
            case 4:
                metodoPagamento = "Crédito";
                System.out.print("Quantas parcelas (2-6)? ");
                parcelas = lerInteiro();
                if (parcelas < 2 || parcelas > 6) {
                    System.out.println("Número de parcelas inválido!");
                    return;
                }
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        facade.definirFormaPagamento(reserva, metodoPagamento, parcelas);
        System.out.println("✓ Forma de pagamento: " + metodoPagamento);
    }

    private static void verDisponibilidades() {
        System.out.println("\n=== DISPONIBILIDADES ===");
        facade.listarDisponibilidades();
    }

    private static int lerInteiro() {
        try {
            int valor = Integer.parseInt(scanner.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            System.out.print("Entrada inválida. Digite um número: ");
            return lerInteiro();
        }
    }
}
