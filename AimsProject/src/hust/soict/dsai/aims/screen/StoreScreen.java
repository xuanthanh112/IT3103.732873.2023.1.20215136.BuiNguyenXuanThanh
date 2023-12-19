package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Để khi đóng cửa sổ, chương trình sẽ kết thúc
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookBtn = new JMenuItem("Add Book");
        smUpdateStore.add(addBookBtn);
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddBook(store, cart);
            }
        });

        JMenuItem addCDBtn = new JMenuItem("Add CD");
        smUpdateStore.add(addCDBtn);
        addCDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCompactDisc(store, cart);
            }
        });

        JMenuItem addDVDBtn = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVDBtn);
        addDVDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddDigitalVideoDisc(store, cart);
            }
        });

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Bui Nguyer Xuan Thanh- 20215136");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 1));

        // Sử dụng forEach loop thay vì for loop
        for (Media media : store.getItemsInStore()) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }

        return center;
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
