package hust.soict.dsai.aims.test.store;
import  hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        var store = new Store();
        var dvd1 = new DigitalVideoDisc("conan");
        store.addDVD(dvd1);
        store.removeDVD(dvd1);
    }
}
