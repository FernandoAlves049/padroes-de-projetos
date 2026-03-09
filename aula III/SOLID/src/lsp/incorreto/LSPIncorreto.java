package lsp.incorreto;

/**
 * =====================================================
 * PRINCÍPIO: Liskov Substitution Principle (LSP)
 * STATUS: INCORRETO - VIOLA O PRINCÍPIO
 * =====================================================
 *
 * PROBLEMA:
 * VIOLAÇÃO CLÁSSICA - Quadrado herda de Retângulo:
 * Um Quadrado tem lados iguais, então sobreescreve setLargura e setAltura
 * para manter ambos iguais. Porém, quem espera um Retângulo vai calcular
 * a área errada, pois o comportamento é DIFERENTE do esperado.
 *
 * "Objetos de uma subclasse devem poder substituir a superclasse
 * sem quebrar o comportamento do programa."
 */
public class LSPIncorreto {

    static class Retangulo {
        protected int largura;
        protected int altura;

        public void setLargura(int largura) {
            this.largura = largura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public int calcularArea() {
            return largura * altura;
        }
    }

    // ❌ Quadrado HERDA de Retângulo mas QUEBRA o contrato da superclasse!
    static class Quadrado extends Retangulo {

        @Override
        public void setLargura(int valor) {
            this.largura = valor;
            this.altura = valor; // ❌ força lados iguais
        }

        @Override
        public void setAltura(int valor) {
            this.largura = valor; // ❌ força lados iguais
            this.altura = valor;
        }
    }

    static void testarRetangulo(Retangulo r) {
        r.setLargura(5);
        r.setAltura(3);
        System.out.println("Largura definida: 5 | Altura definida: 3");
        System.out.println("Área esperada  : 15");
        System.out.println("Área calculada : " + r.calcularArea());
        System.out.println("Resultado OK?  : " + (r.calcularArea() == 15));
    }

    public static void main(String[] args) {
        System.out.println("=== LSP - CÓDIGO INCORRETO ===\n");

        System.out.println("--- Testando com Retangulo (funciona): ---");
        testarRetangulo(new Retangulo());

        System.out.println();
        System.out.println("--- Testando com Quadrado (QUEBRA!): ---");
        testarRetangulo(new Quadrado()); // ❌ não pode substituir Retângulo!

        System.out.println("\n⚠  PROBLEMA: Substituir Retângulo por Quadrado quebra o resultado!");
        System.out.println("   O Quadrado modifica o comportamento herdado, violando o LSP.");
    }
}
