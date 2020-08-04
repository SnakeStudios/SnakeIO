package com.voteservers.snakeio.common;

import com.voteservers.snakeio.SnakeIO;
import com.voteservers.snakeio.Utils.CloseStatus;
import com.voteservers.snakeio.events.events.ClientConnectEvent;
import com.voteservers.snakeio.events.events.ClientDisconnectEvent;
import com.voteservers.snakeio.events.events.ClientErrorEvent;
import com.voteservers.snakeio.events.events.ClientMessageEvent;
import com.voteservers.snakeio.task.ReconnectTask;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WSClient extends WebSocketClient {

    private ReconnectTask reconnectTask;

    public WSClient(URI serverUri) {
        super(serverUri);

        this.reconnectTask = new ReconnectTask(this);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        new ClientConnectEvent(this, serverHandshake).callEvent();
    }

    @Override
    public void onMessage(String s) {
        new ClientMessageEvent(this, s).callEvent();
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        new ClientDisconnectEvent(this, new CloseStatus(code, reason, remote)).callEvent();
//        SnakeIO.getLogger().warning("Client has disconnected from the server, trying to reconnect.");

        if (!SnakeIO.closing) {
            // Starting reconnect task

            if (!this.reconnectTask.isRunning())
                this.reconnectTask.startAsync();
        }
    }

    @Override
    public void onError(Exception e) {
        new ClientErrorEvent(this, e).callEvent();
    }
}
