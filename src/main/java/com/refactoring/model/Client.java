package com.refactoring.model;

import lombok.Getter;

@Getter
public final class Client {
    private final String email;
    private final String name;

    public Client(String email, String name) {
        if (email == null) {
            throw new IllegalArgumentException("The email must not be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("The name must not be null");
        }
        this.email = email;
        this.name = name;
    }
}
