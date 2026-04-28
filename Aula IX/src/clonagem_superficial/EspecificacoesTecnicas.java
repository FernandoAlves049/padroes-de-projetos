package clonagem_superficial;

/**
 * Objeto interno que compõe o Violão.
 * Na CLONAGEM SUPERFICIAL, apenas a referência é copiada —
 * ou seja, o clone e o original apontam para o MESMO objeto
 * EspecificacoesTecnicas.
 */
public class EspecificacoesTecnicas {

    private String peso;
    private double preco;
    private String nivel; // Ex: Iniciante, Intermediário, Profissional

    public EspecificacoesTecnicas(String peso, double preco, String nivel) {
        this.peso = peso;
        this.preco = preco;
        this.nivel = nivel;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPreco() {
        return String.format("%.2f", preco);
    }

    public double getPrecoDouble() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "EspecificacoesTecnicas{peso='" + peso + "', preco=" + preco + ", nivel='" + nivel + "'}";
    }
}
