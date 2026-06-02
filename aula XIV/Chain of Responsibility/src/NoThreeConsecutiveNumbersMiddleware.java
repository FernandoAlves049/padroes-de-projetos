public class NoThreeConsecutiveNumbersMiddleware extends Middleware {
    @Override
    protected boolean process(HttpRequest req, HttpResponse res) {
        String pwd = (String) req.body.get("password");
        for (int i = 0; i + 2 < pwd.length(); i++) {
            char a = pwd.charAt(i);
            char b = pwd.charAt(i + 1);
            char c = pwd.charAt(i + 2);
            if (Character.isDigit(a) && Character.isDigit(b) && Character.isDigit(c)) {
                int ia = a - '0';
                int ib = b - '0';
                int ic = c - '0';
                if (ib == ia + 1 && ic == ib + 1) {
                    res.set(400, "Bad Request (senha não pode conter 3 números consecutivos: exemplo '123')");
                    return false;
                }
            }
        }
        return true;
    }
}
