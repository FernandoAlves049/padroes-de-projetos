public abstract class Funcionario extends Pessoa implements Departamento {
    private String nomeDepto;

    @Override
    public String getNomeDepartamento() { return nomeDepto; }
    
    @Override
    public void setNomeDepartamento(String nome) { this.nomeDepto = nome; }

    public abstract double calcSalario();
    public abstract double comissao();
}