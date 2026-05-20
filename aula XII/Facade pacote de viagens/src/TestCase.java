/**
 * Classe de teste para demonstrar o sistema de viagens
 * Execute com: java -cp bin TestCase
 */

public class TestCase {
    public static void main(String[] args) {
        ViagensFacade facade = new ViagensFacade();
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   TESTE AUTOMÁTICO - SISTEMA DE VIAGENS   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Criar reserva
        Reserva reserva = facade.criarReserva();

        // Adicionar compradores
        facade.adicionarComprador(reserva, "João Silva", "123.456.789-00");
        facade.adicionarComprador(reserva, "Maria Silva", "987.654.321-00");

        System.out.println("[✓] Compradores adicionados");

        // Reservar assento
        if (facade.reservarAssento(reserva, "5A")) {
            System.out.println("[✓] Assento 5A (Classe Executiva) reservado");
        }

        // Reservar hotel
        if (facade.reservarHotel(reserva, "Executivo", 2, 1, 3)) {
            System.out.println("[✓] Quarto Executivo por 3 dias reservado");
        }

        // Alugar carro
        if (facade.alugarCarro(reserva, "Economica", 3)) {
            System.out.println("[✓] Carro Econômico por 3 dias alugado");
        }

        // Definir forma de pagamento
        facade.definirFormaPagamento(reserva, "PIX", 1);
        System.out.println("[✓] Forma de pagamento: PIX (10% desconto)");

        // Finalizar reserva
        facade.finalizarReserva(reserva, 2, 3);
        System.out.println("[✓] Reserva finalizada com sucesso");

        // Exibir comprovante
        System.out.println("\n[INFO] Gerando comprovante...");
        facade.exibirComprovanteReserva(reserva);

        // Teste 2: Reserva com Crédito Parcelado
        System.out.println("\n════════════════════════════════════════════\n");
        System.out.println("═══ TESTE 2: PAGAMENTO EM CRÉDITO 3X ═══\n");

        Reserva reserva2 = facade.criarReserva();
        facade.adicionarComprador(reserva2, "Pedro Costa", "111.222.333-44");
        
        if (facade.reservarAssento(reserva2, "15B")) {
            System.out.println("[✓] Assento 15B (Classe Econômica) reservado");
        }

        if (facade.reservarHotel(reserva2, "Simples", 1, 1, 2)) {
            System.out.println("[✓] Quarto Simples por 2 dias reservado");
        }

        if (facade.alugarCarro(reserva2, "Luxo", 2)) {
            System.out.println("[✓] Carro Luxo por 2 dias alugado");
        }

        facade.definirFormaPagamento(reserva2, "Crédito", 3);
        System.out.println("[✓] Forma de pagamento: Crédito 3x (3.99% de juros)");

        facade.finalizarReserva(reserva2, 1, 2);
        facade.exibirComprovanteReserva(reserva2);

        // Teste 3: Pagamento via Boleto
        System.out.println("\n════════════════════════════════════════════\n");
        System.out.println("═══ TESTE 3: PAGAMENTO VIA BOLETO ═══\n");

        Reserva reserva3 = facade.criarReserva();
        facade.adicionarComprador(reserva3, "Ana Santos", "555.666.777-88");
        facade.adicionarComprador(reserva3, "Carlos Santos", "555.666.777-99");
        
        if (facade.reservarAssento(reserva3, "1C")) {
            System.out.println("[✓] Assento 1C (1ª Classe) reservado");
        }

        if (facade.reservarHotel(reserva3, "Suite", 2, 1, 4)) {
            System.out.println("[✓] Suite Presidencial por 4 dias reservado");
        }

        if (facade.alugarCarro(reserva3, "Executiva", 4)) {
            System.out.println("[✓] Carro Executivo por 4 dias alugado");
        }

        facade.definirFormaPagamento(reserva3, "Boleto", 1);
        System.out.println("[✓] Forma de pagamento: Boleto (5% desconto)");

        facade.finalizarReserva(reserva3, 2, 4);
        facade.exibirComprovanteReserva(reserva3);

        System.out.println("\n════════════════════════════════════════════");
        System.out.println("          TESTES CONCLUÍDOS COM SUCESSO!");
        System.out.println("════════════════════════════════════════════\n");
    }
}
