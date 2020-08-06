package listener;

import com.voteservers.socket.events.events.ClientConnectEvent;
import com.voteservers.socket.events.system.EventHandler;
import com.voteservers.socket.events.system.Listener;

@Listener
public class test {

    @EventHandler
    public void onConnect(ClientConnectEvent e) {
        System.out.println("ME CONECTE XD");

        e.getWebSocket().send("auth::hello_world");
    }

}
