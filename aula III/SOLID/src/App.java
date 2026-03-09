/**
 * ╔══════════════════════════════════════════════════════════╗
 * ║ DEMONSTRAÇÃO DOS PRINCÍPIOS SOLID EM JAVA ║
 * ║ Aula III — PP ║
 * ╚══════════════════════════════════════════════════════════╝
 *
 * Execute com:
 * javac **\/*.java App.java
 * java App
 */
public class App {

    static final String SEP = "\n" + "=".repeat(60) + "\n";

    public static void main(String[] args) {

        System.out.println(SEP);
        System.out.println("   SOLID — Single Responsibility Principle (SRP)");
        System.out.println(SEP);
        srp.incorreto.SRPIncorreto.main(args);
        System.out.println(SEP);
        srp.correto.SRPCorreto.main(args);

        System.out.println(SEP);
        System.out.println("   SOLID — Open/Closed Principle (OCP)");
        System.out.println(SEP);
        ocp.incorreto.OCPIncorreto.main(args);
        System.out.println(SEP);
        ocp.correto.OCPCorreto.main(args);

        System.out.println(SEP);
        System.out.println("   SOLID — Liskov Substitution Principle (LSP)");
        System.out.println(SEP);
        lsp.incorreto.LSPIncorreto.main(args);
        System.out.println(SEP);
        lsp.correto.LSPCorreto.main(args);

        System.out.println(SEP);
        System.out.println("   SOLID — Interface Segregation Principle (ISP)");
        System.out.println(SEP);
        isp.incorreto.ISPIncorreto.main(args);
        System.out.println(SEP);
        isp.correto.ISPCorreto.main(args);

        System.out.println(SEP);
        System.out.println("   SOLID — Dependency Inversion Principle (DIP)");
        System.out.println(SEP);
        dip.incorreto.DIPIncorreto.main(args);
        System.out.println(SEP);
        dip.correto.DIPCorreto.main(args);

        System.out.println(SEP);
        System.out.println("   FIM DA DEMONSTRAÇÃO — Todos os princípios SOLID");
        System.out.println(SEP);
    }
}
