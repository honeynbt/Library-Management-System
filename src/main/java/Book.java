import java.util.Objects;

public class Book {
    private static int counter =1;
    private final String id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;


    public Book(String title, String author, int totalCopies) {
        this.id = "B" + counter++;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getTotalCopies() { return totalCopies; }
    public int getAvailableCopies() { return availableCopies; }

    public boolean issueOneCopy() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    public void returnOneCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Available: " + availableCopies + "/" + totalCopies + "]";
    }

}
