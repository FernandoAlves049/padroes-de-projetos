public class PacoteCaixaSurpresa extends PacoteDecorator {
    public PacoteCaixaSurpresa(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String getDescricao() {
        return assinatura.getDescricao() + " + Pacote 3: caixa surpresa com produtos relacionados a filmes e séries";
    }

    @Override
    public double getPreco() {
        return assinatura.getPreco() + 29.99;
    }
}