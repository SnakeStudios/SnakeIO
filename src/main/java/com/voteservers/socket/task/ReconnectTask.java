package com.voteservers.socket.task;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.voteservers.socket.SnakeIO;
import org.java_websocket.client.WebSocketClient;

import java.util.concurrent.TimeUnit;

public class ReconnectTask extends AbstractScheduledService {

    private WebSocketClient webSocketClient;

    public ReconnectTask(WebSocketClient webSocketClient) {
        this.webSocketClient = webSocketClient;
    }

    @Override
    protected void runOneIteration() throws Exception {
        SnakeIO.getLogger().info("Trying to reconnect to server.");
        if (webSocketClient.isOpen()) {
            SnakeIO.getLogger().info("Reconnected.");
            this.stopAsync();
            return;
        }
        webSocketClient.reconnect();
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedRateSchedule(10, 10, TimeUnit.SECONDS);
    }
}
