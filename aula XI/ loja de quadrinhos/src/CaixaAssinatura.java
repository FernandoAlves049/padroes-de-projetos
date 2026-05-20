import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Locale;

public class CaixaAssinatura {
    private NivelCliente nivel;
    private List<Item> itens;
    private List<Item> itensDisponiveis;

    public CaixaAssinatura(NivelCliente nivel) {
        this.nivel = nivel;
        this.itens = new ArrayList<>();
        this.itensDisponiveis = inicializarItensDisponiveis();
        preencherCaixa();
    }

    private List<Item> inicializarItensDisponiveis() {
        List<Item> lista = new ArrayList<>();
        lista.add(new Item("Quadrinho", 15.00));
        lista.add(new Item("Chaveiro", 5.00));
        lista.add(new Item("Busto", 10.00));
        lista.add(new Item("Adesivo", 1.00));
        lista.add(new Item("Poster", 25.00));
        lista.add(new Item("Camiseta", 25.00));
        lista.add(new Item("Caneta", 3.00));
        lista.add(new Item("Miniatura", 20.00));
        return lista;
    }

    private void preencherCaixa() {
        Random random = new Random();
        int quantidadeMaxima = nivel.getQuantidadeItens();

        for (int i = 0; i < quantidadeMaxima; i++) {
            int indiceAleatorio = random.nextInt(itensDisponiveis.size());
            Item itemSelecionado = itensDisponiveis.get(indiceAleatorio);
            itens.add(new Item(itemSelecionado.getNome(), itemSelecionado.getPreco()));
        }
    }

    public NivelCliente getNivel() {
        return nivel;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void exibirConteudo() {
        System.out.println("======================================");
        System.out.println("CAIXA DE ASSINATURA - NÍVEL " + nivel);
        System.out.println("======================================");
        System.out.println("Itens na caixa (" + itens.size() + "):");
        System.out.println();

        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + ". " + itens.get(i));
        }

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("VALOR TOTAL DA CAIXA: " + String.format(Locale.forLanguageTag("pt-BR"), "R$ %.2f", getValorTotal()));
        System.out.println("======================================");
    }
}
