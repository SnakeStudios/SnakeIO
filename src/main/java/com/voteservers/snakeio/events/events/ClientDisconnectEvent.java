package com.voteservers.snakeio.events.events;

import com.voteservers.snakeio.Utils.CloseStatus;
import com.voteservers.snakeio.events.system.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.java_websocket.WebSocket;

@Data
@AllArgsConstructor
public class ClientDisconnectEvent extends Event {

    private WebSocket webSocket;
    private CloseStatus closeStatus;

}
