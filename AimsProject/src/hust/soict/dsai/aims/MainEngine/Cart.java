package hust.soict.dsai.aims.MainEngine;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.exception.PlayerException;
import java.util.Arrays;

public class Cart extends FirstMenu {
    public Cart(FirstMenu menu) {
        super(menu);
        options = Arrays.asList(
                "Filter medias in cart",
                "Sort medias in cart",
                "Remove media from cart",
                "Play a media",
                "Place order"
        );
    }

    @Override
    protected void displayInfo() {
        cart.print();
    }

    @Override
    protected void handleChoice(int choice) {
        Media item = null;
        if (choice >= 3 && choice <= 4) {
            System.out.print("Enter title of item: ");
            var search = scanner.nextLine();
            item = store.searchByTitle(search.trim());

            if (item == null) {
                System.out.println("No item with that title!");
                scanner.nextLine();
                return;
            }
        }

        switch(choice) {
            case 1:
                new CartFilter(this).display();
                break;
            case 2:
                new CartSort(this).display();
                break;
            case 3:
                cart.removeMedia(item);
                scanner.nextLine();
                break;
            case 4:
                item.tryPlay();
                scanner.nextLine();
                break;
            case 5:
                cart.placeOrder();
                scanner.nextLine();
                break;
        }
    }
}
