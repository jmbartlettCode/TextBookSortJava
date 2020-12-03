/*
 * Josh Bartlett
 * February 29, 2020
 * Assignment 5.1
 * Bellevue University
 * TextBook.java
 */

public class TextBook {
    // declare variables for use in TextBook class
    private String author, title, isbn;
    private int pageCount;
    private double price;
    // Constructor for TextBook object
    public TextBook(String author, String title, int pageCount, String isbn, double price){
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.price = price;
    }
    // gets and sets for all data fields
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getPageCount(){
        return pageCount;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
