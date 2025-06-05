package com.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public String clientName;
    public String clientEmail;
    public List<String> products = new ArrayList<>();
    public List<Integer> quantities = new ArrayList<>();
    public List<Double> prices = new ArrayList<>();
    public double discountRate = 0.1;

    public void printInvoice() {
        double total = 0;
        System.out.println("Cliente: " + clientName);
        for (int i = 0; i < products.size(); i++) {
            System.out.println(quantities.get(i) + "x " + products.get(i) + " - R$" + prices.get(i));
            total += prices.get(i) * quantities.get(i);
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + (total * discountRate));
        System.out.println("Total final: R$" + (total * (1 - discountRate)));
    }

    public void sendEmail() {
        EmailService.sendEmail(clientEmail, "Pedido recebido! Obrigado pela compra.");
    }
}
