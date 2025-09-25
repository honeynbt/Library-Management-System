import java.util.HashSet;
import java.util.Set;

public class User {
    private static int counter = 1;
    private final String userId;
    private String name;
    private Set<Book> borrowedBooks;

    public User(String name) {
        this.userId = "U" + counter++;
        this.name = name;
        this.borrowedBooks = new HashSet<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public Set<Book> getBorrowedBooks() { return borrowedBooks; }

    public boolean borrowBook(Book book) {
        return borrowedBooks.add(book);
    }

    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    public boolean hasBorrowed(String bookId) {
        return borrowedBooks.stream().anyMatch(b -> b.getId().equalsIgnoreCase(bookId));
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name +
                ", Borrowed Books: " + borrowedBooks.size();
    }
}
