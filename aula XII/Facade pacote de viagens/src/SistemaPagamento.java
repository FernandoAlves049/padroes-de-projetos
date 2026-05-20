import java.util.HashMap;
import java.util.Map;

public class SistemaPagamento {
    private Map<String, Pagamento> metodosPagamento;

    public SistemaPagamento() {
        this.metodosPagamento = new HashMap<>();
        inicializarMetodos();
    }

    private void inicializarMetodos() {
        metodosPagamento.put("PIX", new Pagamento("PIX", 10.0, true));
        metodosPagamento.put("Boleto", new Pagamento("Boleto", 5.0, true));
        metodosPagamento.put("Débito", new Pagamento("Débito", 0.0, false));
    }

    public Pagamento obterMetodo(String tipo) {
        return metodosPagamento.get(tipo);
    }

    public Pagamento obterMetodoParcelado(int parcelas) {
        if (parcelas > 1 && parcelas <= 6) {
            return new Pagamento("Crédito", 3.99, false, parcelas);
        }
        return null;
    }

    public void listarMetodos() {
        System.out.println("\n=== FORMAS DE PAGAMENTO ===");
        System.out.println("PIX - 10% de desconto");
        System.out.println("Boleto - 5% de desconto");
        System.out.println("Débito - Sem juros/descontos");
        System.out.println("Crédito - até 6 parcelas (3.99% de juros por parcela a partir da 2ª)");
    }

    public double procesarPagamento(String metodoPagamento, int parcelas, double valor) {
        Pagamento pagamento = null;

        if (metodoPagamento.equalsIgnoreCase("Crédito")) {
            pagamento = obterMetodoParcelado(parcelas);
        } else {
            pagamento = obterMetodo(metodoPagamento);
        }

        if (pagamento != null) {
            return pagamento.calcularValorFinal(valor);
        }
        return valor;
    }
}
