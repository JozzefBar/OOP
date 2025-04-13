package bookstore;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String ISBN;
    private final String title;
    private final String author;
    private final int year;

    /**
     * Calculate the checksum of the ISBN.
     * ISBN may be ISBN-10 or ISBN-13.
     * ISBN is represented as a string without hyphens.
     * If the input contains any hyphens, spaces, or other characters which are not digits or the character X,
     * the potentialISBN check returns false.
     * Only check the checksum, you may disregard any other information the ISBN contains (e.g. country code).
     * @param potentialISBN the string the check. It must only contain characters 0-9, X.
     * @return true if the potentialISBN is a valid ISBN, false otherwise
     */
    public static boolean isISBNValid(String potentialISBN) {
        if (potentialISBN == null) return false;
        if (potentialISBN.length() != 10 && potentialISBN.length() != 13) return false;

        int num, sum = 0;
        for (int i = 0; i < potentialISBN.length(); i++) {
            num = potentialISBN.charAt(i) == 'X' ? 10 : potentialISBN.charAt(i) - '0';

            if(potentialISBN.length() == 10)
                sum += num*(10-i);
            else
                sum += (i % 2 == 1) ? num * 3 : num;
        }

        if(potentialISBN.length() == 10) return sum%11 == 0;
        else return sum%10 == 0;
    }

    /**
     * Initialize the book.
     * @param ISBN a valid ISBN
     * @param title a non-null, non-empty title of the book
     * @param author a non-null, non-empty full name of the author
     * @param year a non-negative year of publication
     * @throws IllegalArgumentException if any of the parameters are invalid
     */
    public Book(String ISBN, String title, String author, int year) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty() || year < 0 || !isISBNValid(ISBN))
            throw new IllegalArgumentException("Nesplnená podmienka");

        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year &&
                ISBN.equals(book.ISBN) &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, author, year);
    }

    @Override
    public int compareTo(Book other) {
        int cmp = Integer.compare(this.year, other.year);
        if (cmp != 0) {
            return cmp;
        }
        return this.ISBN.compareTo(other.ISBN);
    }
}