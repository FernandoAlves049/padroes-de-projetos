package clonagem_superficial;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Fabrica de Violoes - Registro de Prototipos (Prototype Registry).
 */
public class FabricaDeVioloes {

    public static final String CLASSICO    = "classico";
    public static final String FOLK        = "folk";
    public static final String FLET        = "flet";
    public static final String JUMBO       = "jumbo";
    public static final String SETE_CORDAS = "7cordas";
    public static final String DOZE_CORDAS = "12cordas";
    public static final String ZERO        = "zero";
    public static final String DUPLO_ZERO  = "duplozero";
    public static final String TRIPLO_ZERO = "triplozero";

    private final Map<String, Violao> catalogo = new LinkedHashMap<>();

    public FabricaDeVioloes() {
        catalogo.put(CLASSICO,    new ViolaoClassico());
        catalogo.put(FOLK,        new ViolaoFolk());
        catalogo.put(FLET,        new ViolaoFlet());
        catalogo.put(JUMBO,       new ViolaoJumbo());
        catalogo.put(SETE_CORDAS, new Violao7Cordas());
        catalogo.put(DOZE_CORDAS, new Violao12Cordas());
        catalogo.put(ZERO,        new ViolaoZero());
        catalogo.put(DUPLO_ZERO,  new ViolaoDuploZero());
        catalogo.put(TRIPLO_ZERO, new ViolaoTriploZero());
    }

    public Violao getViolao(String tipo) {
        Violao prototipo = catalogo.get(tipo.toLowerCase());
        if (prototipo == null) {
            throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
        return prototipo.clone();
    }

    public void listarCatalogo() {
        String sep = "+--------------------------------------------------+";
        System.out.println("\n" + sep);
        System.out.printf("|  %-48s|%n", "CATALOGO - FABRICA DE VIOLOES");
        System.out.println(sep);
        int i = 1;
        for (Map.Entry<String, Violao> entry : catalogo.entrySet()) {
            System.out.printf("|  [%d] %-14s %-29s|%n",
                    i++, entry.getKey(), entry.getValue().getNome());
        }
        System.out.println(sep + "\n");
    }
}
