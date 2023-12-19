package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public ObservableList<Media> filterTitle(String title) {
        return itemsOrdered.filtered(media -> media.getTitle().toLowerCase().contains(title.toLowerCase()));
    }

    public ObservableList<Media> filterCost(String cost) {
        return itemsOrdered.filtered(media -> Float.toString(media.getCost()).toLowerCase().contains(cost.toLowerCase()));
    }


    public ObservableList<Media> filterId(String id) {
        return itemsOrdered.filtered(media -> Integer.toString(media.getId()).contains(id));
    }
    public void addMedia(Media media) {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("The item is already in the cart");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The disc has been added");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty");
            return;
        }
        if (!itemsOrdered.contains(media)) {
            System.out.println("The item is not in the cart");
            return;
        }
        itemsOrdered.remove(media);
        System.out.println("The disc has been removed");
    }

    public float totalCost() {
        float sum = 0;
        for (Media item: itemsOrdered)
            sum += item.getCost();
        return sum;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items:");
        for (int i = 0; i < itemsOrdered.size(); ++i)
            System.out.println(i + 1 + ". " + itemsOrdered.get(i).toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }

    public void sortItemsByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortItemsByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public Media searchById(int id) {
        for (Media item: itemsOrdered)
            if (item.matchId(id)) return item;
        return null;
    }
    public Media searchByTitle(String title) {
        for (Media item: itemsOrdered)
            if (item.matchTitle(title)) return item;
        return null;
    }
//    public FilteredList<Media> filterId(String id) {
//        var filtered = new FilteredList<>(itemsOrdered);
//        filtered.setPredicate(media -> false);
//        return filtered;
//    }
//    public FilteredList<Media> filterTitle(String titlePart) {
//        var filtered = new FilteredList<>(itemsOrdered);
//        filtered.setPredicate(media -> media.getTitle().contains(titlePart));
//        return filtered;
//    }

    public void placeOrder() {
        itemsOrdered.clear();
        System.out.println("Your order has been placed!");
    }
}



