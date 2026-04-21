public class CarroBuilder extends VeiculoBuilderBase {
    @Override
    protected String tipo() {
        return "Carro";
    }

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor 1.6 Flex");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Transmissao automatica de 6 marchas");
    }

    @Override
    public void pintar() {
        veiculo.setCor("Prata metalico");
    }

    @Override
    public void instalarRodas() {
        veiculo.setRodas("4 rodas aro 16");
    }
}