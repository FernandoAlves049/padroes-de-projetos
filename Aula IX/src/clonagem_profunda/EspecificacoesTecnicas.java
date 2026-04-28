package clonagem_profunda;

/**
 * Objeto interno que compõe o Violão.
 * Na CLONAGEM PROFUNDA, este objeto também é copiado manualmente,
 * garantindo independência total entre clone e original.
 */
public class EspecificacoesTecnicas {

    private String peso;
    private double preco;
    private String nivel;

    public EspecificacoesTecnicas(String peso, double preco, String nivel) {
        this.peso  = peso;
        this.preco = preco;
        this.nivel = nivel;
    }

    /** Construtor de cópia – usado pela clonagem profunda */
    public EspecificacoesTecnicas(EspecificacoesTecnicas origem) {
        this.peso  = origem.peso;
        this.preco = origem.preco;
        this.nivel = origem.nivel;
    }

    public String getPeso() { return peso; }
    public void setPeso(String peso) { this.peso = peso; }

    public String getPreco() { return String.format("%.2f", preco); }
    public double getPrecoDouble() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    @Override
    public String toString() {
        return "EspecificacoesTecnicas{peso='" + peso + "', preco=" + preco + ", nivel='" + nivel + "'}";
    }
}
