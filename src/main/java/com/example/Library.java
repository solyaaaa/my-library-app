package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Library class that manages a collection of books
 */
public class Library {
    private List<Book> books;
    
    /**
     * Constructor - initializes an empty library
     */
    public Library() {
        this.books = new ArrayList<>();
    }
    
    /**
     * Add a book to the library
     * @param book The book to add
     * @return true if successfully added
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        
        // Check if book with same ISBN already exists
        for (Book existingBook : books) {
            if (existingBook.getIsbn().equals(book.getIsbn())) {
                return false; // Book with this ISBN already exists
            }
        }
        
        books.add(book);
        return true;
    }
    
    /**
     * Get all books in the library
     * @return List of all books
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Return a copy to prevent external modification
    }
    
    /**
     * Search for books by title
     * @param title Title to search for
     * @return List of matching books
     */
    public List<Book> searchByTitle(String title) {
        if (title == null) {
            return new ArrayList<>();
        }
        
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
    
    /**
     * Search for books by author
     * @param author Author to search for
     * @return List of matching books
     */
    public List<Book> searchByAuthor(String author) {
        if (author == null) {
            return new ArrayList<>();
        }
        
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
    
    /**
     * Get the total number of books in the library
     * @return Number of books
     */
    public int getBookCount() {
        return books.size();
    }
}