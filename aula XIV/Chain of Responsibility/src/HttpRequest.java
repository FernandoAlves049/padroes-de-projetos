import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    String path;
    String method;
    Map<String, String> headers = new HashMap<>();
    Map<String, Object> body = new HashMap<>();

    HttpRequest(String method, String path) {
        this.method = method;
        this.path = path;
    }
}