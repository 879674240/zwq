package com.xupt.service.enuma;

public enum Laboratory {
    LAB1("软工实验室",0),
    LAB2("玩过实验室",2);
    private String name;
    private int code;

    Laboratory(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
