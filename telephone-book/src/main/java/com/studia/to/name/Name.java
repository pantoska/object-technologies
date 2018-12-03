package com.studia.to.name;

import java.util.Objects;

public class Name extends NameRepository {
    private String name;

    public Name() {
    }

    public Name(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", names=" + names +
                '}';
    }
}
