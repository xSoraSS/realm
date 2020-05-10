package com.example.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Personaje extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;
    private int age;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "id: " + id +
                "\nNombre: " + name +
                "\nEdad: " + age +
                "\nInformación: " + info;
    }
}
