package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private final ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String director,
                       int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title) {
        super(title);
    }
    public String getArtist() {
        return artist;
    }
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    @Override
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            return;
        }
        tracks.add(track);
    }
    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            return;
        }
        tracks.remove(track);
    }

    @Override
    public String toString() {
        return "Compact disc - "
                +  "Title: " + title + " - "
                +  "Category: " + category + " - "
                +  "Director: "+ director + " - "
                +  "Length: "+ length + " - "
                +  "Artist: "+ artist + "- "
                +  "Cost: "+ cost + "VND";
    }

    public String play() throws PlayerException {
        if (tracks.isEmpty()) {
            throw new PlayerException("Cannot play. No tracks available.");
        }
        System.out.println("Playing compact disc: " + title);
        for (var track: tracks) track.play();
        return null;
    }
}
