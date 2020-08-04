package com.voteservers.snakeio.events.events;

import com.voteservers.snakeio.events.system.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.java_websocket.WebSocket;

@Data
@AllArgsConstructor
public class ClientErrorEvent extends Event {

    private WebSocket webSocket;
    private Exception exception;

}
