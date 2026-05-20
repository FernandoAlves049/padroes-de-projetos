import java.util.HashMap;
import java.util.Map;

public class SistemaHotel {
    private Map<String, Quarto> quartos;
    private static final double PRECO_SIMPLES = 200.0;
    private static final double PRECO_EXECUTIVO = PRECO_SIMPLES * 2.5; // 150% a mais
    private static final double PRECO_SUITE = PRECO_EXECUTIVO * 4.0; // 300% a mais

    public SistemaHotel() {
        this.quartos = new HashMap<>();
        inicializarQuartos();
    }

    private void inicializarQuartos() {
        quartos.put("Simples", new Quarto("Simples", PRECO_SIMPLES, 2));
        quartos.put("Executivo", new Quarto("Executivo", PRECO_EXECUTIVO, 2));
        quartos.put("Suite", new Quarto("Suite Presidencial", PRECO_SUITE, 4));
    }

    public Quarto reservarQuarto(String tipoQuarto) {
        if (quartos.containsKey(tipoQuarto)) {
            return quartos.get(tipoQuarto);
        }
        return null;
    }

    public void listarQuartos() {
        System.out.println("\n=== TIPOS DE QUARTOS DISPONÍVEIS ===");
        for (Map.Entry<String, Quarto> entry : quartos.entrySet()) {
            Quarto q = entry.getValue();
            System.out.println(q.getTipo() + " - R$ " + q.getPrecoPorPessoa() + "/pessoa");
        }
    }

    public double calcularDiariaTotal(String tipoQuarto, int quantidadePessoas, int quantidadeDias) {
        Quarto quarto = quartos.get(tipoQuarto);
        if (quarto != null) {
            return quarto.calcularDiaria(quantidadePessoas) * quantidadeDias;
        }
        return 0.0;
    }
}
