public class SpecialCharMiddleware extends Middleware {
    private static final String SPECIALS = "@#$%&*";

    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String pwd = (String) req.body.get("password");
        boolean has = pwd.chars().anyMatch(c -> SPECIALS.indexOf(c) >= 0);
        if (!has) {
            res.set(400, "Bad Request (senha precisa conter pelo menos um caractere especial: @ # $ % & *)");
            return false;
        }
        return true;
    }
}
