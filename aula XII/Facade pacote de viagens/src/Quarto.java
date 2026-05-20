public class Quarto {
    private String tipo;
    private double precoPorPessoa;
    private int capacidade;

    public Quarto(String tipo, double precoPorPessoa, int capacidade) {
        this.tipo = tipo;
        this.precoPorPessoa = precoPorPessoa;
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoPorPessoa() {
        return precoPorPessoa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double calcularDiaria(int quantidadePessoas) {
        return precoPorPessoa * quantidadePessoas;
    }

    @Override
    public String toString() {
        return tipo + " (R$ " + precoPorPessoa + "/pessoa)";
    }
}
