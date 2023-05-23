package LmsFurther;
import LmsFurther.Book;
import java.util.*;
import java.util.function.Consumer;
@FunctionalInterface
interface BookString {
    String format(Book book);
}
public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // CREATE BOOKS
        Book book1 = new Book("The Notebook", "Nicholas Sparks", 1996, 310, "Fiction");
        Book book2 = new Book("Dear John", "Nicholas Sparks", 2006, 219, "Non-Fiction");
        Book book3 = new Book("Gretel & Hansel", "Oz Perkins", 2020, 399, "Fiction");
        // CREATE USER
        User userA = new User("Adam", "234234234");
        User userB = new User("Bob", "675675675");
        User userC = new User("Charlie", "882342312");
        // ADDING BOOK TO LIBRARY
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        System.out.println("Name: " + userA.getName() + ", Library card number: " + userA.getLibraryCardNum());
        System.out.println("Name: " + userB.getName() + ", Library card number: " + userB.getLibraryCardNum());
        System.out.println("Name: " + userC.getName() + ", Library card number: " + userC.getLibraryCardNum());
        System.out.println();

        // FIND BOOK BY PUB YEAR
        List<Book> booksByYear = library.findBooksByPublicationYear(1996);
        System.out.println("Book published in 1996:");
        booksByYear.forEach(book -> System.out.println(book.getTitle()));
        System.out.println();

        // FIND BOOK BY AUTHOR
        List<Book> booksByAuthor = library.findBooksByAuthor("Oz Perkins");
        System.out.println("Book by Oz Perkins:");
        booksByAuthor.forEach(book -> System.out.println(book.getTitle()));
        System.out.println();

        // FINDING BOOK WITH MOST PAGES
        Book bookWithMostPages = library.findBookWithMostPages();
        System.out.println("Book with the most pages:");
        System.out.println(bookWithMostPages.getTitle());
        System.out.println();

        // FIND BOOK WITH MORE THAN 300 PAGES
        List<Book> booksWithMoreThanPages = library.findBooksByMinPages(300);
        System.out.println("Books with 300+ pages:");
        booksWithMoreThanPages.forEach(book -> System.out.println(book.getTitle()));
        System.out.println();

        // PRINTING BOOK TITLES IN THE LIBRARY, SORT ABC
        List<String> sortedTitles = library.getAllBookTitlesSorted();
        System.out.println("Book titles in the library (sorted-A-Z):");
        sortedTitles.forEach(System.out::println);
        System.out.println();

        // FIND BOOK BY CATEGORY-FICTION
        List<Book> booksByCategory = library.findBooksByCategory("Fiction");
        System.out.println("Books in the Fiction category:");
        booksByCategory.forEach(book -> System.out.println(book.getTitle()));
        System.out.println();


        // LOAN BOOKS TO USER
        userA.loanBook(book1);
        userC.loanBook(book2);
        userB.loanBook(book3);

        // RETURNING BOOK
        userC.returnBook(book2);

        // CALCULATING LATE FEES
        double lateFees = userA.calculateLateFees();
        System.out.println("Late fees ( USER): $" + lateFees);
        System.out.println();

        // DEFINE FORMATTER USING LAMBDA EXPRESSION
        BookString formatter = book -> "Title: " + book.getTitle()
                + ", Author: " + book.getAuthor()
                + ", Year: " + book.getPublicationYear()
                + ", Pages: " + book.getPages()
                + ", Category: " + book.getCategory();

        // PRINT ALL BOOK INFO INTO A STRING USING FORMATTER
        System.out.println("Quick Book info: ");
        System.out.println(formatter.format(book1));
        System.out.println(formatter.format(book2));
        System.out.println(formatter.format(book3));


        // LAMBDA EXPRESSION TO PRINT RETURNED BOOK
        Consumer<Book> returnAction = book -> {
            System.out.println("Returned book: " + book.getTitle());
        };
    }
}
