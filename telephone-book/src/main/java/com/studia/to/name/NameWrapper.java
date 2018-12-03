package com.studia.to.name;

public class NameWrapper {
    String name;
    String surname;
    public NameWrapper(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String  getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "NameWrapper{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
