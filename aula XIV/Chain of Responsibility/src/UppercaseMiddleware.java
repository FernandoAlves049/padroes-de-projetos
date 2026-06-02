public class UppercaseMiddleware extends Middleware {
    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        Object pwdObj = req.body.get("password");
        if (pwdObj == null || !(pwdObj instanceof String)) {
            res.set(400, "Bad Request (senha ausente)");
            return false;
        }
        String pwd = (String) pwdObj;
        boolean hasUpper = pwd.chars().anyMatch(Character::isUpperCase);
        if (!hasUpper) {
            res.set(400, "Bad Request (senha precisa conter pelo menos uma letra maiúscula)");
            return false;
        }
        return true;
    }
}
