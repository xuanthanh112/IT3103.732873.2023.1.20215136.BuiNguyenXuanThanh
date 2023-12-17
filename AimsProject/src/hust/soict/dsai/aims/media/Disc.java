package hust.soict.dsai.aims.media;

public abstract class Disc extends Media implements Playable{
    protected int length;
    protected String director;


    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title) {
        super(title);
    }

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    @Override
    public String toString() {
        return "Disc - "
                +  "Title: "  + title +  " - "
                +  "Category: " +  category + ": "
                +  "Length: " +  length + ": "
                +  "Director: " +  director + ": "
                +  "Cost: " + cost + "VND";
    }
}
