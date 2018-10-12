package com.example.demo.util;

import java.util.HashMap;

public class StatusMap extends HashMap {
    private StatusMap() {}

    private static class SingletonInstance {
        private static final StatusMap INSTANCE = new StatusMap();
        static {
            INSTANCE.put("0000","请求成功");
            INSTANCE.put("2002","系统错误");
            INSTANCE.put("3001","用户不存在");
        }

    }

    public static StatusMap getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
