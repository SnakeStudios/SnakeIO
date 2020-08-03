package com.voteservers.snakeio;

import com.voteservers.snakeio.client.SnakeIOClient;
import com.voteservers.snakeio.managers.EventsManager;
import com.voteservers.snakeio.server.SnakeIOServer;

public class SnakeIO {

    private static EventsManager eventsManager;

    public static SnakeIOClient createClient(String server) {
        return new SnakeIOClient(server);
    }

    public static SnakeIOServer createServer(int port) {
        return createServer(port, "127.0.0.1");
    }

    public static SnakeIOServer createServer(int port, String hostname) {
        SnakeIOServer snakeIOServer = new SnakeIOServer(port, hostname);


        return snakeIOServer;
    }


    public static EventsManager getEventsManager() {
        return eventsManager;
    }
}
