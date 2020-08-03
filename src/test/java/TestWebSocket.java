import com.voteservers.snakeio.common.WebSocket;
import lombok.SneakyThrows;

import java.net.URI;
import java.util.Date;


public class TestWebSocket {

    public static Date lastPing;

    public static void main(String[] args) {
//        connectRealSocket();
        connectLocalSocket();
    }


    public static long checkPing() {
        if (lastPing == null)
            lastPing = new Date();

        Date now = new Date();

        return now.getTime() - lastPing.getTime();
    }

    @SneakyThrows
    public static void connectLocalSocket() {
        WebSocket webSocket = new WebSocket(new URI("ws://localhost:8000/"));
        webSocket.connect();
    }

    @SneakyThrows
    public static void connectRealSocket() {
        WebSocket webSocket = new WebSocket(new URI("http://vs.voteservers.com:8003/"));
        webSocket.connect();
    }


}
