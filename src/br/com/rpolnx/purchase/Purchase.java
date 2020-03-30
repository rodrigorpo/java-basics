package br.com.rpolnx.purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Purchase {
    protected BigDecimal value;
    protected List<Item> items;
    protected LocalDateTime time;

    Purchase(List<Item> items) {
        this.items = items;
        this.value = this.getAllPrice();
        this.time = LocalDateTime.now();
    }

    public BigDecimal getValue() {
        return value;
    }

    public List<Item> getItems() {
        return items;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public enum Item {
        NOTEBOOK(BigDecimal.valueOf(2500)),
        MOUSE(BigDecimal.valueOf(240)),
        KEYBOARD(BigDecimal.valueOf(300));

        Item(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getPrice() {
            return price;
        }

        private BigDecimal price;
    }

    public abstract Purchase purchase();

    protected BigDecimal getAllPrice() {
        return this.items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "value=" + value +
                ", items=" + items +
                ", time=" + time +
                '}';
    }
}
