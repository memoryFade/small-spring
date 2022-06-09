package com.memoryFaded.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashmap = new HashMap<>();

    static {
        hashmap.put("10001", "人物A");
        hashmap.put("10002", "人物B");
        hashmap.put("10003", "人物C");
    }

    public String queryUserName(String uId) {
        return hashmap.get(uId);
    }
}
