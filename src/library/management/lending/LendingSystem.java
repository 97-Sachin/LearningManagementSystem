package library.management.lending;

import library.management.Patron.Patron;
import library.management.Patron.PatronManagement;
import library.management.book.Book;
import library.management.book.BookManagement;

public class LendingSystem {

    private BookManagement bookManagement;
    private PatronManagement patronManagement;

    public LendingSystem(BookManagement bookManagement, PatronManagement patronManagement) {
        this.bookManagement = bookManagement;
        this.patronManagement = patronManagement;
    }

    public boolean checkoutBook(String isbn, String memberId) {
        Book book = bookManagement.searchByIsbn(isbn);
        Patron patron = patronManagement.getPatron(memberId);

        if (book != null && book.isAvailable() && patron != null) {
            book.setAvailable(false);
            patron.getBorrowedBooks().add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, String memberId) {
        Patron patron = patronManagement.getPatron(memberId);

        if (patron != null) {
            for (Book book : patron.getBorrowedBooks()) {
                if (book.getIsbn().equals(isbn)) {
                    book.setAvailable(true);
                    patron.getBorrowedBooks().remove(book);
                    return true;
                }
            }
        }
        return false;
    }
}
