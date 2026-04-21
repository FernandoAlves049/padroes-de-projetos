public class CaminhaoBuilder extends VeiculoBuilderBase {
    @Override
    protected String tipo() {
        return "Caminhao";
    }

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor diesel 6 cilindros");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Transmissao manual reforcada de 10 marchas");
    }

    @Override
    public void pintar() {
        veiculo.setCor("Branco utilitario");
    }

    @Override
    public void instalarRodas() {
        veiculo.setRodas("6 rodas reforcadas");
    }
}