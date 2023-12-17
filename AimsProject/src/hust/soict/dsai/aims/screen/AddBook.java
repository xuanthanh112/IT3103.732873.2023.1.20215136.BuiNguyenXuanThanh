package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends AddItem {
    private Store store;
    private Cart cart;

    public AddBook(Store store, Cart cart) {
        super(store, cart);
        this.store = store;
        this.cart = cart;
    }

    @Override
    JPanel createCenter() {
        JTextField bookName;
        JTextField bookCategory;
        JTextField bookCost;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2));

        center.add(new Label("Enter book's name"));

        bookName = new JTextField(10);
        center.add(bookName);

        center.add(new Label("Enter book's category"));

        bookCategory = new JTextField(10);
        center.add(bookCategory);

        center.add(new Label("Enter book's cost"));

        bookCost = new JTextField(10);
        center.add(bookCost);

        JButton submitBtn = new JButton("Add book");
        center.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookCategory.getText().length() >= 1) {
                    float cost = Float.parseFloat(bookCost.getText());
                    Book newBook = new Book(bookName.getText(), bookCategory.getText(), cost);
                    store.addMedia(newBook);
                } else {
                    store.addMedia(new Book(bookName.getText()));
                }
            }
        });

        return center;
    }
}