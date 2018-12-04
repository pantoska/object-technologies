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
}
