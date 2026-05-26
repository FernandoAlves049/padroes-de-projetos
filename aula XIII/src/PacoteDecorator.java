public abstract class PacoteDecorator extends Assinatura {
    protected final Assinatura assinatura;

    protected PacoteDecorator(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}