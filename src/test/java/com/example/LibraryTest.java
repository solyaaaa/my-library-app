package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Unit tests for the Library class
 */
public class LibraryTest {
    
    private Library library;
    
    @Before
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Test Book 1", "Author 1", "1234567890"));
        library.addBook(new Book("Test Book 2", "Author 2", "0987654321"));
    }
    
    @Test
    public void testAddBook() {
        // Should be able to add a new book with unique ISBN
        assertTrue(library.addBook(new Book("New Book", "New Author", "1111111111")));
        
        // Should not add a book with null value
        assertFalse(library.addBook(null));
        
        // Should not add a book with duplicate ISBN
        assertFalse(library.addBook(new Book("Duplicate ISBN", "Any Author", "1234567890")));
    }
    
    @Test
    public void testGetAllBooks() {
        List<Book> allBooks = library.getAllBooks();
        assertEquals(2, allBooks.size());
    }
    
    @Test
    public void testSearchByTitle() {
        // Should find books with matching title
        List<Book> results = library.searchByTitle("Book 1");
        assertEquals(1, results.size());
        assertEquals("Test Book 1", results.get(0).getTitle());
        
        // Should handle case-insensitive search
        results = library.searchByTitle("book");
        assertEquals(2, results.size());
        
        // Should return empty list for no matches
        results = library.searchByTitle("Nonexistent Book");
        assertTrue(results.isEmpty());
        
        // Should handle null input
        results = library.searchByTitle(null);
        assertTrue(results.isEmpty());
    }
    
    @Test
    public void testSearchByAuthor() {
        // Should find books with matching author
        List<Book> results = library.searchByAuthor("Author 1");
        assertEquals(1, results.size());
        assertEquals("Author 1", results.get(0).getAuthor());
        
        // Should handle case-insensitive search
        results = library.searchByAuthor("author");
        assertEquals(2, results.size());
        
        // Should return empty list for no matches
        results = library.searchByAuthor("Nonexistent Author");
        assertTrue(results.isEmpty());
        
        // Should handle null input
        results = library.searchByAuthor(null);
        assertTrue(results.isEmpty());
    }
    
    @Test
    public void testGetBookCount() {
        assertEquals(2, library.getBookCount());
        
        // Add a book and check if count increases
        library.addBook(new Book("Another Book", "Another Author", "5555555555"));
        assertEquals(3, library.getBookCount());
    }
}