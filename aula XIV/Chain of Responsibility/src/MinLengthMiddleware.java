public class MinLengthMiddleware extends Middleware {
    private final int min;

    public MinLengthMiddleware(int min) {
        this.min = min;
    }

    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String pwd = (String) req.body.get("password");
        if (pwd.length() < min) {
            res.set(400, "Bad Request (senha precisa ter pelo menos " + min + " caracteres)");
            return false;
        }
        return true;
    }
}
