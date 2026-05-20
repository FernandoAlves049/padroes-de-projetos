public class Pagamento {
    private String metodo;
    private double percentual;
    private boolean desconto;
    private int parcelas;

    public Pagamento(String metodo, double percentual, boolean desconto) {
        this.metodo = metodo;
        this.percentual = percentual;
        this.desconto = desconto;
        this.parcelas = 1;
    }

    public Pagamento(String metodo, double percentual, boolean desconto, int parcelas) {
        this.metodo = metodo;
        this.percentual = percentual;
        this.desconto = desconto;
        this.parcelas = parcelas;
    }

    public String getMetodo() {
        return metodo;
    }

    public double getPercentual() {
        return percentual;
    }

    public boolean isDesconto() {
        return desconto;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double calcularValorFinal(double valorOriginal) {
        if (desconto) {
            return valorOriginal * (1 - percentual / 100);
        } else {
            if (parcelas > 1) {
                double juros = percentual * (parcelas - 1);
                return valorOriginal * (1 + juros / 100);
            }
            return valorOriginal;
        }
    }

    @Override
    public String toString() {
        if (desconto) {
            return metodo + " (" + percentual + "% de desconto)";
        } else if (parcelas > 1) {
            return metodo + " - " + parcelas + "x (" + percentual + "% de juros por parcela)";
        } else {
            return metodo + " (sem juros/descontos)";
        }
    }
}
