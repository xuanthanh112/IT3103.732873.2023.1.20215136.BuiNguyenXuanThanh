package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.Comparator.ByCostTitle;
import hust.soict.dsai.aims.media.Comparator.ByTitleCost;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    private static int numItems = 0;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new ByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new ByCostTitle();
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    public Media(String title, String category, float cost) {
        id = numItems++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
    }

    //get methods
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    //
    @Override
    public boolean equals(Object obj) {
        Media media = (Media)obj;
        return Objects.equals(title, media.title);
    }

    public boolean isPlayable() {
        return this instanceof Playable;
    }
    public void tryPlay() {
        if (!isPlayable()) {
            System.out.println("Item is not playable");
            return;
        }
        var playable = (Playable)this;
        playable.play();
    }

    public boolean matchId(int id) { return this.id == id; }
    public boolean matchTitle(String title) { return this.title.equals(title); }

    @Override
    public abstract String toString();
}
