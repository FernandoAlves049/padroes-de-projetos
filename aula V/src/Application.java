public class Application {
    public static void main(String[] args) {
        // Obtém a mesma instância em diferentes partes do código Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("Mensagem do módulo 1");

        Logger logger2 = Logger.getInstance();
        logger2.log("Mensagem do módulo 2");
        
        // Verificando se são a mesma instância
        System.out.println("São iguais: " + (logger1 == logger2));

        // Testando ConfigManager
        ConfigManager config1 = ConfigManager.getInstance();
        ConfigManager config2 = ConfigManager.getInstance();
        System.out.println("ConfigManager instâncias iguais: " + (config1 == config2));
        System.out.println("Propriedade 'app_name': " + config1.getProperty("app_name"));
    }
}
