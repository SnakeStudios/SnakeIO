package listener;

import com.voteservers.snakeio.events.events.ClientConnectEvent;
import com.voteservers.snakeio.events.system.EventHandler;
import com.voteservers.snakeio.events.system.Listener;

@Listener
public class test {

    @EventHandler
    public void onConnect(ClientConnectEvent e) {
        System.out.println("ME CONECTE XD");

        e.getWebSocket().send("auth::hello_world");
    }

}
