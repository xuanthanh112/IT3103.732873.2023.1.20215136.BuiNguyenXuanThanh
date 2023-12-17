package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDisc extends AddItem {
    private Store store;
    private Cart cart;

    public AddCompactDisc(Store store, Cart cart) {
        super(store, cart);
        this.store = store;
        this.cart = cart;
    }

    @Override
    JPanel createCenter() {
        JTextField cdName;
        JTextField cdCategory;
        JTextField cdCost;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2));

        center.add(new Label("Enter CD's name"));

        cdName = new JTextField(10);
        center.add(cdName);

        center.add(new Label("Enter CD's category"));

        cdCategory = new JTextField(10);
        center.add(cdCategory);

        center.add(new Label("Enter CD's cost"));

        cdCost = new JTextField(10);
        center.add(cdCost);

        JButton submitBtn = new JButton("Add CD");
        center.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cdCategory.getText().length() >= 1) {
                    float cost = Float.parseFloat(cdCost.getText());
                    CompactDisc newDVD = new CompactDisc(cdName.getText(), cdCategory.getText(), cost);
                    store.addMedia(newDVD);
                } else {
                    store.addMedia(new CompactDisc(cdName.getText()));
                }
            }
        });

        return center;
    }
}