package com.lagou.domain;

public class Test {
    private Integer sid;
    private String name;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
