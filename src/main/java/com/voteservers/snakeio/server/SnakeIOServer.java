package com.voteservers.snakeio.server;

import com.voteservers.snakeio.common.WSServer;

import java.io.IOException;

public class SnakeIOServer {

    private WSServer server;

    public SnakeIOServer(int port, String hostname) {
        this.server = new WSServer(hostname, port);
    }

    public void open() {
        this.server.start();
    }

    public void close() {
        try {
            this.server.stop();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
