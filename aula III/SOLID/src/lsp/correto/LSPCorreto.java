package lsp.correto;

/**
 * =====================================================
 * PRINCÍPIO: Liskov Substitution Principle (LSP)
 * STATUS: CORRETO - SEGUE O PRINCÍPIO
 * =====================================================
 *
 * SOLUÇÃO:
 * Em vez de herança inadequada, usamos uma hierarquia correta:
 * Tanto Retangulo quanto Quadrado implementam a interface "Forma",
 * cada um com seu próprio cálculo de área.
 *
 * Agora qualquer "Forma" pode substituir outra sem quebrar o programa.
 */
public class LSPCorreto {

    // ✅ Interface com contrato bem definido
    interface Forma {
        int calcularArea();

        String descricao();
    }

    // ✅ Retângulo: largura e altura independentes
    static class Retangulo implements Forma {
        private int largura;
        private int altura;

        public Retangulo(int largura, int altura) {
            this.largura = largura;
            this.altura = altura;
        }

        @Override
        public int calcularArea() {
            return largura * altura;
        }

        @Override
        public String descricao() {
            return "Retângulo [" + largura + " x " + altura + "]";
        }
    }

    // ✅ Quadrado: lado único, sem herdar comportamento de Retângulo
    static class Quadrado implements Forma {
        private int lado;

        public Quadrado(int lado) {
            this.lado = lado;
        }

        @Override
        public int calcularArea() {
            return lado * lado;
        }

        @Override
        public String descricao() {
            return "Quadrado [" + lado + " x " + lado + "]";
        }
    }

    // ✅ Círculo também pode ser adicionado sem problemas!
    static class Circulo implements Forma {
        private int raio;

        public Circulo(int raio) {
            this.raio = raio;
        }

        @Override
        public int calcularArea() {
            return (int) (Math.PI * raio * raio);
        }

        @Override
        public String descricao() {
            return "Círculo [raio=" + raio + "]";
        }
    }

    // ✅ Aceita qualquer Forma — substitua à vontade!
    static void imprimirArea(Forma forma) {
        System.out.println(forma.descricao() + " → Área: " + forma.calcularArea());
    }

    public static void main(String[] args) {
        System.out.println("=== LSP - CÓDIGO CORRETO ===");
        System.out.println("Qualquer Forma pode ser substituída sem quebrar o programa!\n");

        Forma[] formas = {
                new Retangulo(5, 3),
                new Quadrado(4),
                new Circulo(3)
        };

        for (Forma f : formas) {
            imprimirArea(f); // ✅ Todas substituem Forma corretamente!
        }

        System.out.println("\n✅ CORRETO: Retangulo, Quadrado e Circulo implementam Forma.");
        System.out.println("   Qualquer um pode ser passado onde se espera uma Forma!");
    }
}
