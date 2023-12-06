package hust.soict.dsai.aims.MainEngine;

import hust.soict.dsai.aims.media.Media;

import java.util.Arrays;

public class StoreDetail extends FirstMenu {
    private Media item;

    public StoreDetail(FirstMenu menu, Media item) {
        super(menu);
        this.item = item;
        options = Arrays.asList(
                "Add to cart",
                "Play"
        );
    }

    @Override
    protected void displayInfo() {
        System.out.println(item.toString());
    }

    @Override
    protected void handleChoice(int choice) {
        switch(choice) {
            case 1:
                cart.addMedia(item);
                scanner.nextLine();
                break;
            case 2:
                item.tryPlay();
                scanner.nextLine();
                break;
        }
    }
}
