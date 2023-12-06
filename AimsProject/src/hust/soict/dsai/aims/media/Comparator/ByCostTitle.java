package hust.soict.dsai.aims.media.Comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class ByCostTitle
implements Comparator<Media> {
    @Override
    public int compare(Media a, Media b) {
        if (a.getCost() != b.getCost())
            return Float.compare(a.getCost(), b.getCost());
        return a.getTitle().compareTo(b.getTitle());
    }
}
