public class App {
    public static void main(String[] args) {
        Notebook notebookGamer = new NotebookGamer.Builder()
                .comProcessador("Intel Core i7-13700H")
                .comMemoriaRam("32GB DDR5")
                .comArmazenamento("1TB SSD NVMe")
                .comPlacaDeVideo("NVIDIA RTX 4060")
                .comSistemaOperacional("Windows 11 Pro")
                .build();

        Notebook notebookTrabalho = new NotebookTrabalho.Builder()
                .comProcessador("AMD Ryzen 7 7840U")
                .comMemoriaRam("16GB DDR5")
                .comArmazenamento("512GB SSD NVMe")
                .comPlacaDeVideo("Radeon 780M Integrada")
                .comSistemaOperacional("Ubuntu 24.04 LTS")
                .build();

        System.out.println("==============================================");
        System.out.println("      SISTEMA DE CONFIGURACAO DE NOTEBOOKS");
        System.out.println("==============================================");

        exibirConfiguracao("Notebook Gamer", notebookGamer);
        exibirConfiguracao("Notebook de Trabalho", notebookTrabalho);
    }

    private static void exibirConfiguracao(String titulo, Notebook notebook) {
        System.out.println("\n----------------------------------------------");
        System.out.println(titulo);
        System.out.println("----------------------------------------------");
        System.out.println("Processador       : " + notebook.getProcessador());
        System.out.println("Memoria RAM       : " + notebook.getMemoriaRam());
        System.out.println("Armazenamento     : " + notebook.getArmazenamento());
        System.out.println("Placa de Video    : " + notebook.getPlacaDeVideo());
        System.out.println("Sistema Operacional: " + notebook.getSistemaOperacional());
    }
}
