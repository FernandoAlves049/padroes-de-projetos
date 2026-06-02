import java.util.HashMap;
import java.util.Map;

public class App {

    private static void executarCenario(String titulo, HttpRequest request, Middleware chain) {
        System.out.println();
        System.out.println("=== " + titulo + " ===");
        System.out.println("Requisição: " + request.method + " " + request.path);
        System.out.println("Body: " + request.body);

        HttpResponse response = new HttpResponse();
        chain.handle(request, response);

        System.out.println("Resposta: " + response);
    }

    public static void main(String[] args) {
        // Usuários cadastrados (base simples em memória)
        Map<String, String> users = new HashMap<>();
        users.put("alice", "Al1ce@2024");
        users.put("bob", "B0b#Secure");
        users.put("carol", "Car0l%Safe");

        // Monta a cadeia de validação de login/senha
        Middleware chain = new RegisteredMiddleware(users);
        chain
                .setNext(new UppercaseMiddleware())
                .setNext(new LowercaseMiddleware())
                .setNext(new SpecialCharMiddleware())
                .setNext(new ContainsNumberMiddleware())
                .setNext(new NoThreeConsecutiveNumbersMiddleware())
                .setNext(new MinLengthMiddleware(8))
                .setNext(new MaxLengthMiddleware(16))
                .setNext(new LoginHandler(users));

        // Cenários de teste simples
        HttpRequest L1 = new HttpRequest("POST", "/login");
        L1.body.put("login", "unknown");
        L1.body.put("password", "Abc123@#");
        executarCenario("Login 1: usuário não cadastrado", L1, chain);

        HttpRequest L2 = new HttpRequest("POST", "/login");
        L2.body.put("login", "alice");
        L2.body.put("password", "alllower1@");
        executarCenario("Login 2: sem maiúscula", L2, chain);

        HttpRequest L3 = new HttpRequest("POST", "/login");
        L3.body.put("login", "alice");
        L3.body.put("password", "Al1ce@2024");
        executarCenario("Login 3: válido", L3, chain);
    }
}
