package LmsFurther;
import LmsFurther.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String name;
    private String libraryCardNum;
    private List<Book> booksOnLoan;
    private Map<Book, LocalDate> loanedBooks;

    public User(String name, String libraryCardNum) {
        this.name = name;
        this.libraryCardNum = libraryCardNum;
        this.booksOnLoan = new ArrayList<>();
        this.loanedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }
    public String getLibraryCardNum() {
        return libraryCardNum;
    }

    public String getlibraryCardNum() {
        return libraryCardNum;
    }

    public void loanBook(Book book) {
        if (!book.isOnLoan()) {
            booksOnLoan.add(book);
            book.setOnLoan(true);
            loanedBooks.put(book, LocalDate.now());
        }
    }
    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }


    public void returnBook(Book book) {
        if (booksOnLoan.contains(book)) {
            booksOnLoan.remove(book);
            book.setOnLoan(false);
            loanedBooks.remove(book);
        }
    }
//If a book is not returned within 2 weeks, the user should
// start accruing late fees. Implement a system to track and
// calculate these fees.
    public double calculateLateFees() {
        // $1.00 FEE PER DAY-----------
        double lateFeePerDay = 1.0;
        //TWO DAYS LATE-----------------------
        double totalLateFees = 2.0;
        LocalDate currentDate = LocalDate.now();

        for (Map.Entry<Book, LocalDate> entry : loanedBooks.entrySet()) {
            Book book = entry.getKey();
            LocalDate loanDate = entry.getValue();
            long daysOnLoan = currentDate.toEpochDay() - loanDate.toEpochDay();
            if (daysOnLoan > 14) {
                double lateFee = (daysOnLoan - 14) * lateFeePerDay;
                totalLateFees += lateFee;
            }
        }

        return totalLateFees;
    }
}