package hust.soict.dsai.aims.media;

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


    public String play() {
        System.out.println("Playing DVD: " + title);
        System.out.println("DVD length: " + length);
        return null;
    }
}
