import java.util.HashMap;
import java.util.Map;

public class SistemaPassagemAerea {
    private Map<String, Assento> assentos;
    private static final double PRECO_ECONOMICA = 500.0;
    private static final double PRECO_EXECUTIVA = PRECO_ECONOMICA * 2.5; // 250% a mais
    private static final double PRECO_PRIMEIRA = PRECO_EXECUTIVA * 2.5; // 150% a mais

    public SistemaPassagemAerea() {
        this.assentos = new HashMap<>();
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        char[] colunas = {'A', 'B', 'C', 'D', 'E', 'F'};
        String[] localizacoes = {"janela", "meio", "corredor", "corredor", "meio", "janela"};

        for (int fileira = 1; fileira <= 32; fileira++) {
            String classe = definirClasse(fileira);
            double preco = definirPreco(classe);

            for (int col = 0; col < 6; col++) {
                String numeroAssento = fileira + String.valueOf(colunas[col]);
                Assento assento = new Assento(numeroAssento, classe, preco, localizacoes[col]);
                assentos.put(numeroAssento, assento);
            }
        }
    }

    private String definirClasse(int fileira) {
        if (fileira >= 1 && fileira <= 3) {
            return "1a Classe";
        } else if (fileira >= 4 && fileira <= 8) {
            return "Executiva";
        } else {
            return "Econômica";
        }
    }

    private double definirPreco(String classe) {
        switch (classe) {
            case "1a Classe":
                return PRECO_PRIMEIRA;
            case "Executiva":
                return PRECO_EXECUTIVA;
            case "Econômica":
                return PRECO_ECONOMICA;
            default:
                return 0.0;
        }
    }

    public Assento reservarAssento(String numeroAssento) {
        Assento assento = assentos.get(numeroAssento);
        if (assento != null && assento.isDisponivel()) {
            assento.reservar();
            return assento;
        }
        return null;
    }

    public void listarAssentosDisponiveis() {
        System.out.println("\n=== ASSENTOS DISPONÍVEIS ===");
        for (String classe : new String[]{"1a Classe", "Executiva", "Econômica"}) {
            System.out.println("\n" + classe + " (R$ " + definirPreco(classe) + "):");
            for (Map.Entry<String, Assento> entry : assentos.entrySet()) {
                Assento a = entry.getValue();
                if (a.getClasse().equals(classe) && a.isDisponivel()) {
                    System.out.print(a.getNumero() + " ");
                }
            }
            System.out.println();
        }
    }

    public Assento obterAssento(String numeroAssento) {
        return assentos.get(numeroAssento);
    }

    public double obterPrecoAssento(String numeroAssento) {
        Assento assento = assentos.get(numeroAssento);
        if (assento != null) {
            return assento.getPreco();
        }
        return 0.0;
    }
}
