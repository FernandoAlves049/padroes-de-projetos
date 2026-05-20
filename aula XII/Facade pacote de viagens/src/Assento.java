public class Assento {
    private String numero;
    private String classe;
    private double preco;
    private boolean disponivel;
    private String localizacao; // janela, meio, corredor

    public Assento(String numero, String classe, double preco, String localizacao) {
        this.numero = numero;
        this.classe = classe;
        this.preco = preco;
        this.localizacao = localizacao;
        this.disponivel = true;
    }

    public String getNumero() {
        return numero;
    }

    public String getClasse() {
        return classe;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        this.disponivel = false;
    }

    public void cancelarReserva() {
        this.disponivel = true;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    @Override
    public String toString() {
        return "Assento{" +
                "numero='" + numero + '\'' +
                ", classe='" + classe + '\'' +
                ", preco=" + preco +
                ", disponivel=" + disponivel +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
