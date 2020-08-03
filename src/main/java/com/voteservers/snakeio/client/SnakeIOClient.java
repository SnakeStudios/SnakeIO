package com.voteservers.snakeio.client;

import com.voteservers.snakeio.common.WebSocket;
import lombok.SneakyThrows;

import java.net.URI;

public class SnakeIOClient {

    private WebSocket webSocket;

    @SneakyThrows
    public SnakeIOClient(String server) {
        URI url = new URI(server);
        webSocket = new WebSocket(url);
    }

    public void open() {
        this.webSocket.connect();
    }

    public void connect() {
        this.open();
    }


}
