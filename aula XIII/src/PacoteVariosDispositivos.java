public class PacoteVariosDispositivos extends PacoteDecorator {
    public PacoteVariosDispositivos(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String getDescricao() {
        return assinatura.getDescricao() + " + Pacote 1: assistir vídeos em vários dispositivos";
    }

    @Override
    public double getPreco() {
        return assinatura.getPreco() + 19.99;
    }
}