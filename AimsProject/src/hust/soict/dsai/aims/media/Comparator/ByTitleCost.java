package hust.soict.dsai.aims.media.Comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class ByTitleCost
implements Comparator<Media> {
    @Override
    public int compare(Media a, Media b) {
        int titleCompare = a.getTitle().compareTo(b.getTitle());
        if (titleCompare != 0) return titleCompare;
        return Float.compare(a.getCost(), b.getCost());
    }
}
