package com.voteservers.snakeio.common;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocket extends WebSocketClient {

    public WebSocket(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.printf("Connected to Status: %s | Message: %s", serverHandshake.getHttpStatus(), serverHandshake.getHttpStatusMessage());
        send("auth::test");
    }

    @Override
    public void onMessage(String s) {
        System.out.printf("\nMessage: %s", s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.printf("Disconnected. %s %s %s%n", i, s, b);
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }
}
