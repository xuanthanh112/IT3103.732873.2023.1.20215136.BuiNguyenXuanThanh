package hust.soict.dsai.aims.MainEngine;

import hust.soict.dsai.aims.media.Media;

import java.util.Arrays;
import java.util.InputMismatchException;

public class CartFilter extends FirstMenu {
    public CartFilter(FirstMenu menu) {
        super(menu);
        options = Arrays.asList(
                "Filter by ID",
                "Filter by title"
        );
    }

    @Override
    protected void displayInfo() {
        cart.print();
    }

    @Override
    protected void handleChoice(int choice) {
        Media item = null;

        switch(choice) {
            case 1:
                System.out.print("Enter item's ID: ");
                int id = -1;
                try {
                    id = scanner.nextInt();
                } catch (InputMismatchException e) {}
                scanner.nextLine(); // Consume newline char
                item = cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter title of item: ");
                var search = scanner.nextLine();
                item = cart.searchByTitle(search.trim());
                break;
        }
        if (item != null) System.out.println(item.toString());
        else System.out.println("No item found!");

        scanner.nextLine();
    }
}
