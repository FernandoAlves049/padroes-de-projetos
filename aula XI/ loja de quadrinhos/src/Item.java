import java.util.Locale;

public class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String formatarPreco() {
        return String.format(Locale.forLanguageTag("pt-BR"), "R$ %.2f", preco);
    }

    @Override
    public String toString() {
        return nome + " - " + formatarPreco();
    }
}
