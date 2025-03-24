package library.management.Patron;

import java.util.HashMap;
import java.util.Map;

public class PatronManagement {
    private final Map<String, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron) {
        patrons.put(patron.getMemberId(), patron);
    }

    public void updatePatron(String memberId, Patron updatedPatron) {
        patrons.put(memberId, updatedPatron);
    }

    public Patron getPatron(String memberId) {
        return patrons.get(memberId);
    }
}
