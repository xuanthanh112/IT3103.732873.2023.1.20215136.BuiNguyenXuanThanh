package hust.soict.dsai.aims.screen;
import java.io.IOException;
import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        var panel = new JFXPanel();
        add(panel);

        setTitle("Cart");
        setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    var loader = new FXMLLoader(
                            getClass().getResource("cart.fxml"));
                    loader.setController(new CartScreenController(cart));
                    Parent root = loader.load();
                    panel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();


        store.addMedia(new CompactDisc("a", "b", "c", 2,2, "fd"));

        store.addMedia(new DigitalVideoDisc(" Say Goodbye", "Nhac tru tinh", " Pham Viet Thang", 10, 100.0f));

        Book book1 = new Book("DevUp", "Soft Skill", 10.4f);
        store.addMedia(book1);
        Book book2 = new Book("asdfdf", "Soft Skill", 10.4f);
        store.addMedia(book2);
        Book book3 = new Book("asd", "Soft Skill", 10.4f);
        store.addMedia(book3);
        Book book4 = new Book("asdasf", "Soft Skill", 10.4f);
        store.addMedia(book4);
        Book book6 = new Book("dgdfgdf", "Soft Skill", 10.4f);
        store.addMedia(book6);
        Book book7 = new Book("sfwae", "Soft Skill", 10.4f);
        store.addMedia(book7);
        new StoreScreen(store, cart);
    }

}
