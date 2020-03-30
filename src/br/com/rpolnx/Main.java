package br.com.rpolnx;

import br.com.rpolnx.purchase.OnlinePurchase;
import br.com.rpolnx.purchase.PhysicalPurchase;
import br.com.rpolnx.purchase.Purchase;
import br.com.rpolnx.game.FinalFantasyXII;
import br.com.rpolnx.game.Game;
import br.com.rpolnx.game.GtaSanAndreas;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        gameExample();
        purchaseExample();
    }

    private static void gameExample() {
        //From this instance we can use all superclass inherit methods and your own
        FinalFantasyXII finalFantasyXII = new FinalFantasyXII();
        GtaSanAndreas gtaSanAndreas = new GtaSanAndreas();

        System.out.println("References from class itself");
        System.out.println(finalFantasyXII.toString());
        System.out.println(gtaSanAndreas.toString());

        //How to access both common from a reference? Use polymorphism!
        //What polymorphism can achieve is representing classes by a more generic representation
        //In this case, Game is a more generic reference than GtaSanAndreas or FinalFantasyXII
        Game game1 = new FinalFantasyXII(); // we are using superclass reference
        Game game2 = new GtaSanAndreas();

        // We can play both game, because play is a method from Game

        System.out.println("\n\nReference achieved from polymorphism");
        System.out.println(game1);
        game1.play();

        System.out.println("\n");

        System.out.println(game2);
        game2.play();
    }

    private static void purchaseExample() {
        List<Purchase.Item> itemList1 = List.of(Purchase.Item.MOUSE, Purchase.Item.KEYBOARD);
        List<Purchase.Item> itemList2 = List.of(Purchase.Item.MOUSE, Purchase.Item.KEYBOARD, Purchase.Item.NOTEBOOK);

        OnlinePurchase onlinePurchase = new OnlinePurchase(itemList1);
        PhysicalPurchase physicalPurchase = new PhysicalPurchase(itemList2);

        //Access all methods here
        onlinePurchase.getItems();
        onlinePurchase.getTime();
        onlinePurchase.getValue();

        physicalPurchase.getItems();
        physicalPurchase.getTime();
        physicalPurchase.getValue();

        //With polymorphism we can do it:
        Purchase purchase1 = new OnlinePurchase(itemList1);
        Purchase purchase2 = new PhysicalPurchase(itemList2);

        System.out.println("\n\nPurchase example: \n");

        purchase1.purchase();
        System.out.println("");
        purchase2.purchase();

        System.out.println(purchase1.toString());
        System.out.println(purchase2.toString());
    }
}
