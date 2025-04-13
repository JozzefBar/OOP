package bookstore;

import java.util.Set;
import java.util.TreeSet;

public class Customer {
    private final String name;
    private final Set<Book> ownedBooks;

    /**
     * Initialize a customer.
     * @param name the non-null, non-empty name of the customer
     * @throws IllegalArgumentException if the name is invalid
     */
    public Customer(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Nesplnená podmienka");

        this.name = name;
        ownedBooks = new TreeSet<>();
    }

    /**
     * get the name.
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Get the books the customer owns.
     * @return the set of customer's books.
     */
    public Set<Book> getOwnedBooks() {
        return ownedBooks;
    }

    /**
     * Attempt to purchase all books from the specified store which are not yet owned.
     * @param bs the bookstore to purchase from
     * @throws IllegalArgumentException if the bookstore is null
     */
    public void purchaseNewBooks(BookStore bs) {
        if (bs == null) {
            throw new IllegalArgumentException("Nesplnená podmienka");
        }

        for(Book book : bs.getInventory().keySet()){
            if(!ownedBooks.contains(book)) {
                try {
                    bs.sell(book);
                    ownedBooks.add(book);
                    System.out.println("Customer " + name + " has purchased the book " + book.getISBN());
                } catch (NotInInventoryException e) {
                    System.out.println("Customer " + name + " could not buy the book " + book.getISBN());
                }
            }
        }
    }
}
