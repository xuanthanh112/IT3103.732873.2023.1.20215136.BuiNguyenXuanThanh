package hust.soict.dsai.aims.MainEngine;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends FirstMenu {
    public Main(
     hust.soict.dsai.aims.store.Store store,
     hust.soict.dsai.aims.cart.Cart cart,
     Scanner scanner

    ){
        super(store, cart, scanner);
        options = Arrays.asList(
                "View store",
                "Update store",
                "See current cart"
        );
    }
    @Override
    protected void displayInfo() {
        System.out.println("AIMS");
    }

    @Override
    protected void handleChoice(int choice) {
        switch(choice) {
            case 1:
                new Store(this).display();
                break;
            case 2:
                new StoreManage(this).display();
                break;
            case 3:
                new Cart(this).display();
                break;
        }
    }
}
