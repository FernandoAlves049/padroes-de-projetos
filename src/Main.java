import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema de Gestão ===\n");

        Diretor dir = new Diretor();
        dir.setNome("Carlos Alberto");
        dir.setNomeDepartamento("Diretoria Executiva");
        
        Engenheiro eng = new Engenheiro();
        eng.setNome("Eng. Alice");
        eng.setNomeDepartamento("Desenvolvimento de Software");

        Cliente cliente = new Cliente();
        cliente.setNome("Empresa de Suprimentos LTDA");

        System.out.println("Funcionário: " + dir.getNome() + " | Depto: " + dir.getNomeDepartamento());
        System.out.println("Funcionário: " + eng.getNome() + " | Depto: " + eng.getNomeDepartamento());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("\n--- Testando Autenticação (Polimorfismo) ---");

        List<Autenticavel> usuarios = new ArrayList<>();
        usuarios.add(dir);
        usuarios.add(cliente); // Cliente também é Autenticavel

        for (Autenticavel u : usuarios) {
            u.login();
        }

        System.out.println("\n--- Testando Interface Fornecedor ---");
        cliente.fornecerProdutos();
        cliente.emitirNotaFiscal();

        System.out.println("\n=== Fim da Execução ===");
    }
}