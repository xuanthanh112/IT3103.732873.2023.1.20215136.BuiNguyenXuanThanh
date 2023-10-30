public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    public DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered;

    public Cart() {
        this.qtyOrdered = 0;
    }
// so sanh qtyOrdered voi so luong order max
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null)
            return;
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }
// ham xoa dia
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null)
            return;
        if (qtyOrdered == 0) {
            System.out.println("The cart is  empty");
            return;
        }

        var found = false;
        for (int i = 0; i < qtyOrdered; ++i) {
            if (!found && itemsOrdered[i] == disc)
                found = true;
            if (found && i < qtyOrdered - 1) {
                itemsOrdered[i] = itemsOrdered[i + 1];// chuyen phan tu lien ke ben phai len them 1 de xoa disc neu disc khong o vi tri cuoi cung+
            } else if (found) {
                itemsOrdered[i] = null;// neu o vi tri cuoi cung thi cai ve null
            }
        }

        if (!found)
            System.out.println("The disc was not in the cart");
        else {
            System.out.println("The disc has been removed");
            qtyOrdered--;
        }
    }
//ham tinh tong

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; ++i) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}