package com.voteservers.socket;

import com.voteservers.socket.client.SnakeIOClient;
import com.voteservers.socket.managers.EventsManager;
import com.voteservers.socket.server.SnakeIOServer;

import java.util.logging.Logger;

public class SnakeIO {

    private static EventsManager eventsManager = new EventsManager();
    private static Logger logger = Logger.getLogger("SnakeIO");
    public static boolean closing = false;

    public static SnakeIOClient createClient(String server) {
        return new SnakeIOClient(server);
    }

    public static SnakeIOServer createServer(int port) {
        return createServer(port, "127.0.0.1");
    }

    public static SnakeIOServer createServer(int port, String hostname) {
        return new SnakeIOServer(port, hostname);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static EventsManager getEventsManager() {
        return eventsManager;
    }
}
