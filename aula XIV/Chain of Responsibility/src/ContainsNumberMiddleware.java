public class ContainsNumberMiddleware extends Middleware {
    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String pwd = (String) req.body.get("password");
        boolean has = pwd.chars().anyMatch(Character::isDigit);
        if (!has) {
            res.set(400, "Bad Request (senha precisa conter pelo menos um número)");
            return false;
        }
        return true;
    }
}
