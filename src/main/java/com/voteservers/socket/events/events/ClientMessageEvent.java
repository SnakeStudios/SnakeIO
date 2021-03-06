package com.voteservers.socket.events.events;

import com.voteservers.socket.events.system.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.java_websocket.WebSocket;

@Data
@AllArgsConstructor
public class ClientMessageEvent extends Event {

    private WebSocket webSocket;
    private String message;

}
