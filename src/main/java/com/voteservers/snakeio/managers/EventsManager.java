package com.voteservers.snakeio.managers;

import com.voteservers.snakeio.Utils.Data;
import com.voteservers.snakeio.events.system.Event;
import com.voteservers.snakeio.events.system.EventHandler;
import com.voteservers.snakeio.events.system.Listener;
import lombok.Getter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public class EventsManager {

    private final Map<Class<? extends Event>, ArrayList<Data>> listeners;

    public EventsManager() {
        this.listeners = new HashMap<>();
    }

    public void register(Object o) {
        if (Arrays.stream(o.getClass().getAnnotatedInterfaces()).noneMatch(annotatedType -> annotatedType.getType().equals(Listener.class)))
            return;

        for (Method method : o.getClass().getDeclaredMethods()) {
            if (!isValid(method)) {
                register(method, o);
            }
        }
    }

    public void unregister(Object o) {
        this.getListeners().values().forEach(data -> data.removeIf(methodData -> methodData.getClazz().equals(o)));
        checkEmpty();
    }

    private void register(Method method, Object object) {
        Class<?> clazz = method.getParameterTypes()[0];
        Data methodData = new Data(object, method);

        if (!methodData.getMethod().isAccessible()) {
            methodData.getMethod().setAccessible(true);
        }

        if (this.getListeners().containsKey(clazz)) {
            if (!this.getListeners().get(clazz).contains(methodData)) {
                this.getListeners().get(clazz).add(methodData);
            }
        } else {
            ArrayList<Data> dataList = new ArrayList<>();
            dataList.add(methodData);
            this.getListeners().put((Class<? extends Event>) clazz, dataList);
        }
    }

    private boolean isValid(Method method) {
        return !method.isAnnotationPresent(EventHandler.class);
    }

    public ArrayList<Data> getData(Class<? extends Event> clazz) {
        return this.getListeners().get(clazz);
    }


    public void checkEmpty() {
        this.getListeners().entrySet().iterator().forEachRemaining(data -> {
            if (data.getValue().isEmpty()) {
                this.getListeners().remove(data.getKey());
            }
        });
    }

    public void clear() {
        this.getListeners().clear();
    }


}
