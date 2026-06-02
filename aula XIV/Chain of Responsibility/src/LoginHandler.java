import java.util.Map;

public class LoginHandler extends Middleware {
    private final Map<String, String> users;

    public LoginHandler(Map<String, String> users) {
        this.users = users;
    }

    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String login = (String) req.body.get("login");
        String pwd = (String) req.body.get("password");
        String expected = users.get(login);
        if (!expected.equals(pwd)) {
            res.set(401, "Unauthorized (senha incorreta)");
            return false;
        }
        res.set(200, "Login bem-sucedido para usuário: " + login);
        return false; // handled
    }
}
