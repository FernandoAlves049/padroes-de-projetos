public class Veiculo {
    private final String tipo;
    private String motor;
    private String transmissao;
    private String cor;
    private String rodas;

    public Veiculo(String tipo) {
        this.tipo = tipo;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRodas(String rodas) {
        this.rodas = rodas;
    }

    @Override
    public String toString() {
        return "Veiculo {\n" +
            "  tipo: " + tipo + "\n" +
            "  motor: " + motor + "\n" +
            "  transmissao: " + transmissao + "\n" +
            "  cor: " + cor + "\n" +
            "  rodas: " + rodas + "\n" +
            "}";
    }
}