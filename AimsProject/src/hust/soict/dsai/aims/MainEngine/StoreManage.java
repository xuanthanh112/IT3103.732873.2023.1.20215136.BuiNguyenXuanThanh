package hust.soict.dsai.aims.MainEngine;

import hust.soict.dsai.aims.media.Media;

import java.util.Arrays;

public class StoreManage extends FirstMenu {
    public StoreManage(FirstMenu menu) {
        super(menu);
        options = Arrays.asList(
                "Add media",
                "Remove media"
        );
    }

    @Override
    protected void displayInfo() {
        store.print();
    }

    @Override
    protected void handleChoice(int choice) {
        switch (choice) {
            case 1:
                new StoreAdd(this).display();
                break;
            case 2:
                Media item = null;
                System.out.print("Enter item title: ");
                var search = scanner.nextLine();
                item = store.searchByTitle(search.trim());

                if (item == null) System.out.println("No item with that title!");
                else System.out.println("Item has been removed!");

                store.removeMedia(item);
        }
    }
}
