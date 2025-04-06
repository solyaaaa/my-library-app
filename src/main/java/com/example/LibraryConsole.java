package com.example;

import java.util.List;
import java.util.Scanner;

/**
 * Console interface for the library application
 */
public class LibraryConsole {
    private Library library;
    private Scanner scanner;
    
    /**
     * Constructor for LibraryConsole
     * @param library The library to use
     */
    public LibraryConsole(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Displays the main menu and handles user input
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a new book");
            System.out.println("2. List all books");
            System.out.println("3. Search by title");
            System.out.println("4. Search by author");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    addBookMenu();
                    break;
                case 2:
                    listAllBooks();
                    break;
                case 3:
                    searchByTitle();
                    break;
                case 4:
                    searchByAuthor();
                    break;
                case 5:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Menu for adding a new book
     */
    private void addBookMenu() {
        System.out.println("\n----- Add a New Book -----");
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        Book newBook = new Book(title, author, isbn);
        boolean added = library.addBook(newBook);
        
        if (added) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Failed to add book. Book with this ISBN might already exist.");
        }
    }
    
    /**
     * List all books in the library
     */
    private void listAllBooks() {
        System.out.println("\n----- All Books -----");
        List<Book> allBooks = library.getAllBooks();
        
        if (allBooks.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        
        int count = 1;
        for (Book book : allBooks) {
            System.out.println(count + ". " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
            count++;
        }
        System.out.println("Total books: " + library.getBookCount());
    }
    
    /**
     * Search for books by title
     */
    private void searchByTitle() {
        System.out.print("\nEnter title to search: ");
        String title = scanner.nextLine();
        
        List<Book> results = library.searchByTitle(title);
        displaySearchResults(results, "title containing '" + title + "'");
    }
    
    /**
     * Search for books by author
     */
    private void searchByAuthor() {
        System.out.print("\nEnter author to search: ");
        String author = scanner.nextLine();
        
        List<Book> results = library.searchByAuthor(author);
        displaySearchResults(results, "author containing '" + author + "'");
    }
    
    /**
     * Display search results
     * @param results List of books to display
     * @param searchCriteria Description of search criteria
     */
    private void displaySearchResults(List<Book> results, String searchCriteria) {
        System.out.println("\n----- Search Results: Books with " + searchCriteria + " -----");
        
        if (results.isEmpty()) {
            System.out.println("No books found matching your search criteria.");
            return;
        }
        
        int count = 1;
        for (Book book : results) {
            System.out.println(count + ". " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
            count++;
        }
        System.out.println("Found " + results.size() + " book(s).");
    }
    
    /**
     * Clean up resources
     */
    public void close() {
        scanner.close();
    }
}