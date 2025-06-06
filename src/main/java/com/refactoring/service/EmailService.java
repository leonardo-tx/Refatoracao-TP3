package com.refactoring.service;

public final class EmailService {
    public void sendEmail(String email, String message) {
        if (email == null) {
            throw new IllegalArgumentException("The email must not be null.");
        }
        if (message == null) {
            throw new IllegalArgumentException("The message must not be null.");
        }
        System.out.println("Enviando e-mail para " + email + ": " + message);
    }
}
