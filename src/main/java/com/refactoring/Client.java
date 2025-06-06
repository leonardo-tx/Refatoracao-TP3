package com.refactoring;

import lombok.Getter;

@Getter
public class Client {
    private final String email;
    private final String name;

    public Client(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
