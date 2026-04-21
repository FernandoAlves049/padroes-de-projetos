public class MotoBuilder extends VeiculoBuilderBase {
    @Override
    protected String tipo() {
        return "Moto";
    }

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor 300cc monocilindrico");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Transmissao manual de 6 marchas");
    }

    @Override
    public void pintar() {
        veiculo.setCor("Vermelho esportivo");
    }

    @Override
    public void instalarRodas() {
        veiculo.setRodas("2 rodas esportivas");
    }
}