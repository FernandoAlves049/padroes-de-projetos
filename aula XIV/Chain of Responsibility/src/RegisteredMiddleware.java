import java.util.Map;

public class RegisteredMiddleware extends Middleware {
    private final Map<String, String> users; // username -> password

    public RegisteredMiddleware(Map<String, String> users) {
        this.users = users;
    }

    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        Object loginObj = req.body.get("login");
        if (loginObj == null || !(loginObj instanceof String)) {
            res.set(401, "Unauthorized (login ausente)");
            return false;
        }
        String login = (String) loginObj;
        if (!users.containsKey(login)) {
            res.set(401, "Unauthorized (login não cadastrado)");
            return false;
        }
        return true;
    }
}
