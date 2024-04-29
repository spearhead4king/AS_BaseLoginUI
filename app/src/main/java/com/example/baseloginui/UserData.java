package com.example.baseloginui;

import java.util.HashMap;
import java.util.Objects;

public class UserData {
    private static final HashMap<String, HashMap<String, String>> userData;
    // 初始化数据
    static {
        userData = new HashMap<>();

        for (TestData testData : TestData.values()) {
            String[] data = testData.getData().split("\\$");
            HashMap<String, String> user = new HashMap<>();
            user.put("nickname", data[1]);
            user.put("password", data[2]);
            user.put("lastLoginTime", data[3]);

            userData.put(data[0], user);
        }

    }

    public static boolean check(String username, String password) {

        if (userData.containsKey(username)) {
            HashMap<String, String> user = userData.get(username);

            if (user != null) {
                return Objects.equals(user.get("password"), password);
            }
        }
        return false;
    }

}