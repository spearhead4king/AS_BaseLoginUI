package com.example.baseloginui;

public enum TestData {

    USER1("root$root$root$2024.1.1.20.8.0"),
    USER2("user1$ImuFather$yes!yes!yes!$2024.2.2.2.2.2"),
    USER3("user2$abcdefg2$123456$2024.3.3.3.3.3");

    private final String data;

    TestData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
