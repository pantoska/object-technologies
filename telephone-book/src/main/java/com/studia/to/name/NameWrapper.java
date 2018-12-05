package com.studia.to.name;

import java.util.Objects;

public class NameWrapper {
    private Name name;
    private Name surname;

    public NameWrapper(Name name, Name surname) {
        this.name = name;
        this.surname = surname;
    }

    public Name getName() {
        return name;
    }

    public Name getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NameWrapper that = (NameWrapper) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
