public class Diretor extends Funcionario implements Autenticavel {
    @Override
    public double calcSalario() {
        return 5000.0;
    }

    @Override
    public double comissao() {
        return 1000.0;
    }

    @Override
    public boolean login() {
        // Lógica de autenticação
        return true;
    }
}