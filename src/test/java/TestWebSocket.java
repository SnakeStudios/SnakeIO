import com.voteservers.socket.SnakeIO;
import com.voteservers.socket.common.WSClient;
import listener.test;
import lombok.SneakyThrows;

import java.net.URI;
import java.util.Date;


public class TestWebSocket {

    public static Date lastPing;

    public static void main(String[] args) {
        SnakeIO.getEventsManager().register(new test());
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
        WSClient webSocket = new WSClient(new URI("ws://localhost:8002/"));
        webSocket.connect();
    }

    @SneakyThrows
    public static void connectRealSocket() {
        WSClient webSocket = new WSClient(new URI("http://vs.voteservers.com:8003/"));
        webSocket.connect();
    }


}
