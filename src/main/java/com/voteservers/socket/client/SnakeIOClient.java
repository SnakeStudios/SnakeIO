package com.voteservers.socket.client;

import com.voteservers.socket.SnakeIO;
import com.voteservers.socket.common.WSClient;
import lombok.SneakyThrows;

import java.net.URI;

public class SnakeIOClient {

    private WSClient webSocket;

    @SneakyThrows
    public SnakeIOClient(String server) {
        URI url = new URI(server);
        webSocket = new WSClient(url);
    }

    public void open() {
        this.webSocket.connect();
    }

    public void close() {
        SnakeIO.closing = true;
        this.webSocket.close();
    }

    public void connect() {
        this.open();
    }

    public void disconnect() {
        this.close();
    }

}
