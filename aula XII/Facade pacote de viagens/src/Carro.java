public class Carro {
    private String tipo;
    private double precoDiaria;

    public Carro(String tipo, double precoDiaria) {
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public double calcularAluguel(int quantidadeDias) {
        return precoDiaria * quantidadeDias;
    }

    @Override
    public String toString() {
        return tipo + " (R$ " + precoDiaria + "/dia)";
    }
}
