package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    public Cart() {
        this.qtyOrdered = 0;
    }
    // so sanh qtyOrdered voi so luong order max
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) return;
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (var disc: dvdList) addDigitalVideoDisc(disc);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    // ham xoa dia
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) return;
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty");
            return;
        }

        var found = false;
        for (int i = 0; i < MAX_NUMBERS_ORDERED; ++i) {
            if (!found && itemsOrdered[i].equals(disc) )found = true;
            if (found && i < MAX_NUMBERS_ORDERED - 1) {
                itemsOrdered[i] = itemsOrdered[i + 1];// chuyen phan tu lien ke ben phai len them 1 de xoa disc neu disc khong o vi tri cuoi cung+
            } else if (found) {
                itemsOrdered[i] = null;// neu o vi tri cuoi cung thi cai ve null
            }
        }

        if (!found) System.out.println("The disc was not in the cart");
        else {
            System.out.println("The disc has been removed");
            qtyOrdered--;
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; ++i) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void print() {
        System.out.println("*************************************");
        System.out.println("Ordered items:");
        for (int i = 0; i < qtyOrdered; ++i)
            System.out.println(i + 1 + ". " + itemsOrdered[i].toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***********************************");
    }

    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; ++i)
            if (itemsOrdered[i].getId() == id) {
                System.out.println(itemsOrdered[i].toString());
                return;
            }
        System.out.println("not found DVD with this");
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; ++i)
            if (itemsOrdered[i].isMatch(title)) {
                found = true;
                System.out.println(itemsOrdered[i].toString());
            }
        if (!found) System.out.println("not found DVD like this");
    }
}



