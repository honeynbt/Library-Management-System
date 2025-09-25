import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample Data
        library.addBook(new Book("Clean Code", "Robert C. Martin", 3));
        library.addBook(new Book("Effective Java", "Joshua Bloch", 2));
        library.addBook(new Book("C Programming", "Joshua Bloch", 4));
        library.addUser(new User("Abhishek Kumar"));
        library.addUser(new User("Sunidhi Singh"));
        library.addUser(new User("Ashish Kumar"));

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Show All Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");   // NEW
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> library.showAllBooks();
                case 2 -> {
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();
                    library.issueBook(bookId, userId);
                }
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();
                    library.returnBook(bookId, userId);
                }
                case 4 -> {
                    System.out.print("Enter title/author/ID keyword: ");
                    String keyword = sc.nextLine();
                    var results = library.searchBooks(keyword);
                    if (results.isEmpty()) System.out.println("No matches found.");
                    else results.forEach(System.out::println);
                }
                case 5 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }
}
