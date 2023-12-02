package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[Max_Items];
    public static final int Max_Items = 100;
    private int Count = 0;
    public void addDVD(DigitalVideoDisc disc) {
        if (disc == null) return;
        if (Count == Max_Items) {
            System.out.println("The store is full");
            return;
        }
        itemsInStore[Count] = disc;
        Count++;
        System.out.println("The disc has been added");
    }
    public void removeDVD(DigitalVideoDisc disc) {
        if (disc == null) return;
        if (Count == 0) {
            System.out.println("The store is empty");
            return;
        }
        var found = false;
        for (int i = 0; i < Max_Items; ++i) {
            if (!found && itemsInStore[i] != null && itemsInStore[i].equals(disc)) {
                found = true;
            }
            if (found && i < Max_Items - 1) {
                itemsInStore[i] = itemsInStore[i + 1];
            } else if (found) {
                itemsInStore[i] = null;
            }
        }

        if (!found) System.out.println("Our store dont have this disc");
        else { System.out.println("The disc has been removed");
            Count--;
        }
    }
}
