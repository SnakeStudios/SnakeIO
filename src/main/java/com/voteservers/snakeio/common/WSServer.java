package com.voteservers.snakeio.common;

import com.voteservers.snakeio.Utils.CloseStatus;
import com.voteservers.snakeio.events.events.*;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class WSServer extends WebSocketServer {

    public WSServer(String hostname, int port) {
        super(new InetSocketAddress(hostname, port));
    }


    @Override
    public void onStart() {
        new ServerStartEvent().callEvent();
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        new ClientConnectEvent(webSocket, clientHandshake).callEvent();
    }

    @Override
    public void onClose(WebSocket webSocket, int code, String reason, boolean remote) {
        new ClientDisconnectEvent(webSocket, new CloseStatus(code, reason, remote)).callEvent();
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        new ClientMessageEvent(webSocket, s).callEvent();
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        new ClientErrorEvent(webSocket, e).callEvent();
    }

}
