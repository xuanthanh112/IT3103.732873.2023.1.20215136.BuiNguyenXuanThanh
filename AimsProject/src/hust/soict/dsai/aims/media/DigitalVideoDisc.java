package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Compact disc - "
                +  "Title: " + title + " - "
                +  "Category: " + category + " - "
                +  "Director: "+ director + " - "
                +  "Length: "+ length + " - "
                +  "Cost: "+ cost + "VND";
    }


    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + title);
            System.out.println("DVD length: " + length);
            return "Playing DVD: " + title + "\nDVD length: " + length;
        } else {
            throw new PlayerException("Invalid DVD length. Cannot play the DVD.");
        }
    }
}
