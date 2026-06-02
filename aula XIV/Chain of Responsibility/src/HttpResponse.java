public class HttpResponse {
    int status = 200;
    String body = "OK";

    void set(int status, String body) {
        this.status = status;
        this.body = body;
    }

    @Override
    public String toString() {
        return "HTTP " + status + " - " + body;
    }
}