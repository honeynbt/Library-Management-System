import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public List<Book> searchBooks(String keyword) {
        String key = keyword.toLowerCase();
        return books.stream()
                .filter(b -> b.getId().toLowerCase().contains(key) ||
                        b.getTitle().toLowerCase().contains(key) ||
                        b.getAuthor().toLowerCase().contains(key))
                .collect(Collectors.toList());
    }

    public void showAllBooks() {
        System.out.println("\n--- Available Books ---");
        for (Book book : books) System.out.println(book);
    }

    public Book findBookById(String id) {
        for (Book b : books) if (b.getId().equalsIgnoreCase(id)) return b;
        return null;
    }

    public User findUserById(String id) {
        for (User u : users) if (u.getUserId().equalsIgnoreCase(id)) return u;
        return null;
    }

    public void issueBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) { System.out.println("Book not found!"); return; }
        if (user == null) { System.out.println("User not found!"); return; }

        if (user.hasBorrowed(bookId)) {
            System.out.println("This user already has a copy of \"" + book.getTitle() + "\".");
            return;
        }

        if (book.issueOneCopy()) {
            user.borrowBook(book);
            System.out.println("One copy of \"" + book.getTitle() + "\" issued to " + user.getName());
        } else {
            System.out.println("No copies available!");
        }
    }

    public void returnBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) { System.out.println("Book not found!"); return; }
        if (user == null) { System.out.println("User not found!"); return; }


        if (!user.hasBorrowed(bookId)) {
            System.out.println("This user did not borrow that book.");
            return;
        }

        boolean removed = user.returnBook(book);
        if (removed) {
            book.returnOneCopy();
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Unexpected error while returning book.");
        }
    }

}
