package com.example;

/**
 * Main application class
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Starting Library Management System...");
        
        // Create a new library and add some sample books
        Library library = new Library();
        
        // Add some sample books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        
        // Create and start the console interface
        LibraryConsole console = new LibraryConsole(library);
        console.displayMenu();
        console.close();
    }
}