package com.voteservers.snakeio.events.system;

import com.voteservers.snakeio.SnakeIO;
import com.voteservers.snakeio.Utils.Data;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@lombok.Data
public class Event {

    private boolean cancelled;

    public void callEvent() {
        Event event = this;
        ArrayList<Data> dataList = SnakeIO.getEventsManager().getData(event.getClass());

        if (dataList == null) return;
        if (dataList.isEmpty()) return;

        dataList.forEach(data -> {
            // Calling event
            try {
                data.getMethod().invoke(data.getClazz(), event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

}
