public class Gerente extends Funcionario implements Autenticavel {
    @Override
    public double calcSalario() {
        return 0.0;
    }

    @Override
    public double comissao() {
        return 0.0;
    }

    @Override
    public boolean login() {
        return true;
    }
}