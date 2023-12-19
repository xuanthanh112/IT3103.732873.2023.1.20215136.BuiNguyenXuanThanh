//package hust.soict.dsai.aims.screen;
//
//import hust.soict.dsai.aims.media.Media;
//import hust.soict.dsai.aims.media.Playable;
//
//import javax.swing.*;
//
//public class PlayItem extends JDialog {
//    PlayItem(Media media){
//        assert (media.isPlayable());
//        var panel = new JPanel();
//        var label = new JLabel("Playing: " + media.getTitle() + " -- length: " + ((Playable)media).getLength() + " minutes)");
//        panel.add(label);
//        getContentPane().add(panel);
//        // Create close button
//        var closeButton = new JButton("Close");
//        closeButton.addActionListener(e -> setVisible(false));
//        panel.add(closeButton);
//        pack();
//    }
//}
