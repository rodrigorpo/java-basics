package br.com.rpolnx.purchase;

import java.math.BigDecimal;
import java.util.List;

class PaymentApi {
    void realizePayment(BigDecimal ignored) {
        System.out.println("Payment was Successfully");
    }

}

public class OnlinePurchase extends Purchase {
    private final PaymentApi paymentApi;

    public OnlinePurchase(List<Item> items) {
        super(items);
        this.paymentApi = new PaymentApi();
    }

    public void purchase() {
        this.paymentApi.realizePayment(value);

        System.out.println("Success purchasing online");

    }

    @Override
    public String toString() {
        return "OnlinePurchase{" +
                "paymentApi=" + paymentApi +
                ", value=" + value +
                ", items=" + items +
                ", time=" + time +
                '}';
    }
}
