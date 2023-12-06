package hust.soict.dsai.aims;

import hust.soict.dsai.aims.MainEngine.Main;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        var cart = new Cart();
        var store = new Store();
        var scanner = new Scanner(System.in);

        store.addMedia(new DigitalVideoDisc(" Say Goodbye", "Nhac tru tinh", " Pham Viet Thang", 10, 100.0f));
        store.addMedia(new DigitalVideoDisc("Em biet khong", "Nhac that tinh", "Phan Duy Anh", 20, 200.0f));
        store.addMedia(new Book("De ton", "A", 30.0f));
        store.addMedia(new Book("De ba", "B", 40.0f));

        var menu = new Main(store, cart, scanner);
        menu.display();
    }
    }
