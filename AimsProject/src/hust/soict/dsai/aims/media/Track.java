package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        Track track = (Track)obj;
        return title == track.title && length == track.length;
    }

    public void play() {
        System.out.println("Play track: " + title);
        System.out.println("Track length: " + length);
    }
}
