public class App {
    public static void main(String[] args) {
        DiretorMontagem diretor = new DiretorMontagem();

        VeiculoBuilder carroBuilder = new CarroBuilder();
        diretor.montar(carroBuilder);
        Veiculo carro = carroBuilder.getResult();

        VeiculoBuilder caminhaoBuilder = new CaminhaoBuilder();
        diretor.montar(caminhaoBuilder);
        Veiculo caminhao = caminhaoBuilder.getResult();

        VeiculoBuilder motoBuilder = new MotoBuilder();
        diretor.montar(motoBuilder);
        Veiculo moto = motoBuilder.getResult();

        System.out.println("=== Montagem de Veiculos ===");
        System.out.println();

        System.out.println("Carro:");
        System.out.println(carro);
        System.out.println();

        System.out.println("Caminhao:");
        System.out.println(caminhao);
        System.out.println();

        System.out.println("Moto:");
        System.out.println(moto);
    }
}
