package com.voteservers.socket.Utils;

import java.lang.reflect.Method;

@lombok.Data
public class Data {

    private Object clazz;
    private Method method;

    public Data(Object clazz, Method method) {
        this.clazz = clazz;
        this.method = method;
    }

}
