package bookstore;

import java.util.Map;
import java.util.HashMap;

public class BookStore {
    private final String name;
    private final Map<Book, Integer> inventory;

    /**
     * Initialize the bookstore.
     * @param name the non-null, non-empty name of the bookstore
     * @throws IllegalArgumentException if the name is invalid
     */
    public BookStore(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Nesplnená podmienka");

        this.name = name;
        inventory = new HashMap<>();
    }

    /**
     * Add a book to the bookstore's inventory and update the counts accordingly.
     * if the book was never before in the inventory, set its count to 1.
     * otherwise increment its count by 1
     * @param book a book to add, must not be null
     * @throws IllegalArgumentException if the book is null
     */
    public void addToInventory(Book book) {
        if(book == null) throw new IllegalArgumentException("Nesplnená podmienka");
        inventory.put(book, inventory.getOrDefault(book, 0) + 1);
    }

    /**
     * Sell a book.
     * Only sell the book if it is present in the inventory and its count is nonzero.
     * Otherwise, throw {@link NotInInventoryException}.
     * @param book a book to sell
     * @throws IllegalArgumentException if the book is null
     * @throws NotInInventoryException if the book is not in the inventory
     */
    public void sell(Book book) {
        if(book == null) throw new IllegalArgumentException("Nesplnená podmienka");

        else if (!inventory.containsKey(book) || inventory.get(book) == 0)
            throw new NotInInventoryException(book);

        inventory.put(book, inventory.get(book) - 1);
    }

    /**
     * Get the inventory map.
     * @return the inventory
     */
    public Map<Book, Integer> getInventory() {
        return inventory;
    }
}
