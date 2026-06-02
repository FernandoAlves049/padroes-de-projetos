public class MaxLengthMiddleware extends Middleware {
    private final int max;

    public MaxLengthMiddleware(int max) {
        this.max = max;
    }

    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String pwd = (String) req.body.get("password");
        if (pwd.length() > max) {
            res.set(400, "Bad Request (senha não pode ter mais de " + max + " caracteres)");
            return false;
        }
        return true;
    }
}
