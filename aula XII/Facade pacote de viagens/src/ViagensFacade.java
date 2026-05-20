public class ViagensFacade {
    private SistemaPassagemAerea sistemaPassagem;
    private SistemaHotel sistemaHotel;
    private SistemaAluguelCarro sistemaAluguelCarro;
    private SistemaPagamento sistemaPagamento;

    public ViagensFacade() {
        this.sistemaPassagem = new SistemaPassagemAerea();
        this.sistemaHotel = new SistemaHotel();
        this.sistemaAluguelCarro = new SistemaAluguelCarro();
        this.sistemaPagamento = new SistemaPagamento();
    }

    public Reserva criarReserva() {
        return new Reserva();
    }

    public void adicionarComprador(Reserva reserva, String nome, String cpf) {
        reserva.adicionarComprador(new Comprador(nome, cpf));
    }

    public boolean reservarAssento(Reserva reserva, String numeroAssento) {
        Assento assento = sistemaPassagem.reservarAssento(numeroAssento);
        if (assento != null) {
            reserva.setAssentoAereo(numeroAssento);
            return true;
        }
        return false;
    }

    public boolean reservarHotel(Reserva reserva, String tipoQuarto, int quantidadePessoas, 
                                 int diasHotel, int quantidadeDias) {
        Quarto quarto = sistemaHotel.reservarQuarto(tipoQuarto);
        if (quarto != null && quarto.getCapacidade() >= quantidadePessoas) {
            reserva.setHotel(tipoQuarto, diasHotel);
            return true;
        }
        return false;
    }

    public boolean alugarCarro(Reserva reserva, String tipoCarro, int diasCarro) {
        Carro carro = sistemaAluguelCarro.alugarCarro(tipoCarro);
        if (carro != null) {
            reserva.setCarro(tipoCarro, diasCarro);
            return true;
        }
        return false;
    }

    public void definirFormaPagamento(Reserva reserva, String metodo, int parcelas) {
        reserva.setPagamento(metodo, parcelas);
    }

    public void finalizarReserva(Reserva reserva, int quantidadePessoas, int diasHotel) {
        // Calcular preço da passagem
        double precoPassagem = sistemaPassagem.obterPrecoAssento(reserva.getAssentoAereo());

        // Calcular preço do hotel
        double precoHotel = sistemaHotel.calcularDiariaTotal(reserva.getHotel(), 
                                                            quantidadePessoas, reserva.getDiasHotel());

        // Calcular preço do aluguel de carro
        double precoCarro = sistemaAluguelCarro.calcularCustoAluguel(reserva.getCarro(), 
                                                                    reserva.getDiasCarro());

        double precoTotal = precoPassagem + precoHotel + precoCarro;
        reserva.setPrecos(precoPassagem, precoHotel, precoCarro);

        // Processar pagamento
        double precoFinal = procesarPagamento(reserva, precoTotal);
        reserva.setPrecoFinal(precoFinal);
    }

    private double procesarPagamento(Reserva reserva, double valor) {
        String metodoPagamento = reserva.getMetodoPagamento();
        int parcelas = reserva.getParcelasCredito();
        return sistemaPagamento.procesarPagamento(metodoPagamento, parcelas, valor);
    }

    public void exibirComprovanteReserva(Reserva reserva) {
        reserva.imprimirComprovante();
    }

    public void listarDisponibilidades() {
        sistemaPassagem.listarAssentosDisponiveis();
        sistemaHotel.listarQuartos();
        sistemaAluguelCarro.listarCarros();
        sistemaPagamento.listarMetodos();
    }
}
