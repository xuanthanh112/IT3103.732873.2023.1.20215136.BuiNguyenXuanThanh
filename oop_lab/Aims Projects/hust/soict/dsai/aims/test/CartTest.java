package hust.soict.dsai.aims.test;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // tao gio hang
        var cart = new Cart();
        //tao dia moi
        var dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );
        var dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        );
        var dvd3 = new DigitalVideoDisc(
                "Aladin",
                "Animation",
                18.99f
        );
        // them dia
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // Test the search methods here:
        cart.searchById(2);// search by id
        cart.searchByTitle("The Lion King");// search by title
        cart.searchById(4);
        cart.searchByTitle("Doraemon");
    }
}
