import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private List<Comprador> compradores;
    private String assentoAereo;
    private String tipoQuarto;
    private int diasHotel;
    private String tipoCarro;
    private int diasCarro;
    private String metodoPagamento;
    private int parcelasCredito;
    private double precoPassagem;
    private double precoHotel;
    private double precoCarro;
    private double precoTotal;
    private double precoFinal;

    public Reserva() {
        this.compradores = new ArrayList<>();
    }

    public void adicionarComprador(Comprador comprador) {
        compradores.add(comprador);
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }

    public void setAssentoAereo(String assentoAereo) {
        this.assentoAereo = assentoAereo;
    }

    public String getAssentoAereo() {
        return assentoAereo;
    }

    public void setHotel(String tipoQuarto, int dias) {
        this.tipoQuarto = tipoQuarto;
        this.diasHotel = dias;
    }

    public void setCarro(String tipoCarro, int dias) {
        this.tipoCarro = tipoCarro;
        this.diasCarro = dias;
    }

    public void setPagamento(String metodo, int parcelas) {
        this.metodoPagamento = metodo;
        this.parcelasCredito = parcelas;
    }

    public void setPrecos(double passagem, double hotel, double carro) {
        this.precoPassagem = passagem;
        this.precoHotel = hotel;
        this.precoCarro = carro;
        this.precoTotal = passagem + hotel + carro;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public String getHotel() {
        return tipoQuarto;
    }

    public String getCarro() {
        return tipoCarro;
    }

    public int getDiasHotel() {
        return diasHotel;
    }

    public int getDiasCarro() {
        return diasCarro;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public int getParcelasCredito() {
        return parcelasCredito;
    }

    public void imprimirComprovante() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("         COMPROVANTE DE RESERVA");
        System.out.println("════════════════════════════════════════════\n");

        System.out.println("--- DADOS DOS COMPRADORES ---");
        for (Comprador c : compradores) {
            System.out.println(c);
        }

        System.out.println("\n--- DETALHES DA COMPRA ---");
        System.out.println("Assento Aéreo: " + assentoAereo);
        System.out.println("Hotel: " + tipoQuarto + " (" + diasHotel + " dias)");
        System.out.println("Carro: " + tipoCarro + " (" + diasCarro + " dias)");

        System.out.println("\n--- RESUMO DE PREÇOS ---");
        System.out.printf("Passagem Aérea: R$ %.2f\n", precoPassagem);
        System.out.printf("Hotel: R$ %.2f\n", precoHotel);
        System.out.printf("Aluguel de Carro: R$ %.2f\n", precoCarro);
        System.out.printf("Valor Total: R$ %.2f\n", precoTotal);

        double diferenca = precoFinal - precoTotal;
        if (diferenca < 0) {
            System.out.printf("Desconto: R$ %.2f (%.2f%%)\n", Math.abs(diferenca), 
                            (Math.abs(diferenca) / precoTotal) * 100);
        } else if (diferenca > 0) {
            System.out.printf("Acréscimo (Juros): R$ %.2f (%.2f%%)\n", diferenca, 
                            (diferenca / precoTotal) * 100);
        }

        System.out.println("\n--- FORMA DE PAGAMENTO ---");
        if (metodoPagamento.equalsIgnoreCase("Crédito")) {
            System.out.println(metodoPagamento + " - " + parcelasCredito + "x de R$ " + 
                             String.format("%.2f", precoFinal / parcelasCredito));
        } else {
            System.out.println(metodoPagamento);
        }

        System.out.printf("\nVALOR FINAL A PAGAR: R$ %.2f\n", precoFinal);
        
        // QR Code Simulado
        System.out.println("\n--- QR CODE DE VALIDAÇÃO ---");
        exibirQRCodeSimulado();
        
        System.out.println("\n════════════════════════════════════════════\n");
    }

    private void exibirQRCodeSimulado() {
        System.out.println("  ██████╗ ██████╗  ███████╗ ");
        System.out.println("  ██╔═══╝ ██╔══██╗ ██╔════╝ ");
        System.out.println("  ██║     ██████╔╝ ███████╗ ");
        System.out.println("  ██║     ██╔══██╗ ╚════██║ ");
        System.out.println("  ╚██████╗██║  ██║ ███████║ ");
        System.out.println("   ╚═════╝╚═╝  ╚═╝ ╚══════╝ ");
        System.out.println("\n  Código: RES" + String.format("%06d", (int)(Math.random() * 1000000)));
    }
}
