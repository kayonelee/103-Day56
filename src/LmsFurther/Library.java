package LmsFurther;
import LmsFurther.Book;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Consumer;
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
//Add a book to the library.
//Remove a book from the library by title.
//Find all books published in a specific year.
//Find all books by a specific author.
//Find the book with the most pages.
//Find all books with more than n pages.
//Print all book titles in the library, sorted alphabetically.

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(b -> b.getTitle().equals(title));
    }

    public List<Book> findBooksByPublicationYear(int year) {
        return books.stream()
                .filter(b -> b.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksByMinPages(int minPages) {
        return books.stream()
                .filter(b -> b.getPages() > minPages)
                .collect(Collectors.toList());
    }

    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(b -> b.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public void loanBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null && !book.isOnLoan()) {
            book.setOnLoan(true);
        }
    }
//USING RETURNACTION PARAMETER OF TYPE CONSUMER-ACCEPT SINGLE INPUT -RETURN NO RESULT
    public void returnBook(String title, Consumer<Book> returnAction) {
        Book book = findBookByTitle(title);
        if (book != null && book.isOnLoan()) {
            book.setOnLoan(false);
            returnAction.accept(book);
        }
    }


    private Book findBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}