public class DiretorMontagem {
    public void montar(VeiculoBuilder builder) {
        builder.reset();
        builder.construirMotor();
        builder.construirTransmissao();
        builder.pintar();
        builder.instalarRodas();
    }
}