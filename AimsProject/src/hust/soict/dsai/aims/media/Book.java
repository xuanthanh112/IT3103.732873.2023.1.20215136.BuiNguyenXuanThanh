package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends  Media{

    private ArrayList<String> authors = new ArrayList<String>();
    public Book(String title, String category, float cost) {super(title, category, cost);
    }
    public boolean isAuthor(String authorName) {
        return authors.contains(authorName);
    }// Kiem tra authorName da ton tai trong List hay chua
    public void addAuthor(String authorName) {
        if (isAuthor(authorName)) {
            System.out.println("Author is in the list");
            return;
        }
        authors.add(authorName);
        System.out.println("Author has added to the list");
    }
    public ArrayList<String> getAuthors() { return authors;}
    public void removeAuthor(String authorName) {
        if (!isAuthor(authorName)) {
            System.out.println("Author is not in the list");
            return;
        }
        authors.remove(authorName);
        System.out.println("Author has removed from the list");
    }
//toString method
    @Override
    public String toString() {
        return "Book - "
                +  "Title: "  + title +  " - "
                +  "Category: " +  category + "- "
                +  "Cost: " + cost + "VND";
    }

}

