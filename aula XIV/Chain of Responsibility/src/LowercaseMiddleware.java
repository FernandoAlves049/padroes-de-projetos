public class LowercaseMiddleware extends Middleware {
    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String pwd = (String) req.body.get("password");
        boolean hasLower = pwd.chars().anyMatch(Character::isLowerCase);
        if (!hasLower) {
            res.set(400, "Bad Request (senha precisa conter pelo menos uma letra minúscula)");
            return false;
        }
        return true;
    }
}
