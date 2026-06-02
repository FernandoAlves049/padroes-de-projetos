public abstract class Middleware {
    protected Middleware next;

    public Middleware setNext(Middleware next) {
        this.next = next;
        return next;
    }

    public final void handle(HttpRequest req, HttpResponse res) {
        boolean shouldContinue = process(req, res);
        if (!shouldContinue) {
            return;
        }
        if (next == null) {
            return;
        }
        next.handle(req, res);
    }

    protected abstract boolean process(HttpRequest req, HttpResponse res);
}