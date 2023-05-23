package LmsFurther;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category; //ADDED CATEGORY UPDATE
    private boolean isOnLoan;

//    CONSTRUCTORS-------------
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category; //ADDED CATEGORY UPDATE
        this.isOnLoan = false;
    }

//    GETTERS----------------------
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public String getCategory() {  //ADDED CATEGORY UPDATE
        return category;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }
//SETTER-----------
    public void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan;
    }
}

//Update the Book class to include a category attribute (String).
// Categories could be things like "Fiction", "Non-Fiction",
// "Science", "History", etc. Add functionality to the Library
// class to find all books in a specific category.