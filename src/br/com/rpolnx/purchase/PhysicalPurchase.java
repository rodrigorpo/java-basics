package br.com.rpolnx.purchase;

import java.util.List;

public class PhysicalPurchase extends Purchase {

    public PhysicalPurchase(List<Item> items) {
        super(items);
    }

    @Override
    public void purchase() {
        attendCustomer();
        receivePayment();
        System.out.println("Success physical purchasing");
    }

    private void attendCustomer() {
        System.out.println("Do some attendant's logic here");
    }

    private void receivePayment() {
        System.out.println("Choose card or money and receive payment");
    }

    @Override
    public String toString() {
        return "PhysicalPurchase{" +
                "value=" + value +
                ", items=" + items +
                ", time=" + time +
                '}';
    }
}
