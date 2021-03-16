package com.bjsxt.ref.bean;

public class User {
    public int id;
    private String uname;
    private int age;

    public User() {
    }

    public User(int id, String uname, int age) {
        this.id = id;
        this.uname = uname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int testFunc(int num1, String str1) {
        return num1+num1;
    }

}
