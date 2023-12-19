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

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Để khi đóng cửa sổ, chương trình sẽ kết thúc
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {

        Cart cart = new Cart();


        cart.addMedia(new CompactDisc("a", "b", "c", 2,2, "fd"));

        cart.addMedia(new DigitalVideoDisc(" Say Goodbye", "Nhac tru tinh", " Pham Viet Thang", 10, 100.0f));

        Book book1 = new Book("DevUp", "Soft Skill", 10.4f);
        cart.addMedia(book1);
        Book book2 = new Book("asdfdf", "Soft Skill", 10.4f);
        cart.addMedia(book2);
        Book book3 = new Book("asd", "Soft Skill", 10.4f);
        cart.addMedia(book3);
        Book book4 = new Book("asdasf", "Soft Skill", 10.4f);
        cart.addMedia(book4);
        Book book6 = new Book("dgdfgdf", "Soft Skill", 10.4f);
        cart.addMedia(book6);
        Book book7 = new Book("sfwae", "Soft Skill", 10.4f);
        cart.addMedia(book7);
        new CartScreen( cart);
    }

}
