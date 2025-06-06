package com.refactoring.service;

public final class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Enviando e-mail para " + to + ": " + message);
    }
}
