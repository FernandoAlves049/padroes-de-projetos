public abstract class VeiculoBuilderBase implements VeiculoBuilder {
    protected Veiculo veiculo;

    protected abstract String tipo();

    @Override
    public void reset() {
        veiculo = new Veiculo(tipo());
    }

    @Override
    public Veiculo getResult() {
        Veiculo resultado = veiculo;
        reset();
        return resultado;
    }
}