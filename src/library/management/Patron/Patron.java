package library.management.Patron;

import library.management.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String memberId;
    private final List<Book> borrowedBooks = new ArrayList<>();

    // Constructor
    public Patron(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}
