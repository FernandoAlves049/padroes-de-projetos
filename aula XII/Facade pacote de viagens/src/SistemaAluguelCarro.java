import java.util.HashMap;
import java.util.Map;

public class SistemaAluguelCarro {
    private Map<String, Carro> carros;
    private static final double PRECO_ECONOMICA = 150.0;
    private static final double PRECO_EXECUTIVA = PRECO_ECONOMICA * 2.0; // 100% a mais
    private static final double PRECO_LUXO = PRECO_EXECUTIVA * 2.0; // 100% a mais

    public SistemaAluguelCarro() {
        this.carros = new HashMap<>();
        inicializarCarros();
    }

    private void inicializarCarros() {
        carros.put("Economica", new Carro("Econômico", PRECO_ECONOMICA));
        carros.put("Executiva", new Carro("Executivo", PRECO_EXECUTIVA));
        carros.put("Luxo", new Carro("Luxo", PRECO_LUXO));
    }

    public Carro alugarCarro(String tipoCarro) {
        if (carros.containsKey(tipoCarro)) {
            return carros.get(tipoCarro);
        }
        return null;
    }

    public void listarCarros() {
        System.out.println("\n=== TIPOS DE CARROS DISPONÍVEIS ===");
        for (Map.Entry<String, Carro> entry : carros.entrySet()) {
            Carro c = entry.getValue();
            System.out.println(c.getTipo() + " - R$ " + c.getPrecoDiaria() + "/dia");
        }
    }

    public double calcularCustoAluguel(String tipoCarro, int quantidadeDias) {
        Carro carro = carros.get(tipoCarro);
        if (carro != null) {
            return carro.calcularAluguel(quantidadeDias);
        }
        return 0.0;
    }
}
