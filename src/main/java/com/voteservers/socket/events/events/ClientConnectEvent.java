package com.voteservers.socket.events.events;

import com.voteservers.socket.events.system.Event;
import lombok.Data;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ServerHandshake;

@Data
//@AllArgsConstructor
public class ClientConnectEvent extends Event {

    private WebSocket webSocket;
    private ClientHandshake clientHandshake;
    private ServerHandshake serverHandshake;

    public ClientConnectEvent(WebSocket webSocket, ClientHandshake clientHandshake) {
        this.webSocket = webSocket;
        this.clientHandshake = clientHandshake;
    }

    public ClientConnectEvent(WebSocket webSocket, ServerHandshake serverHandshake) {
        this.webSocket = webSocket;
        this.serverHandshake = serverHandshake;
    }

}
