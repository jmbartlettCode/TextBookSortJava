/*
 * Josh Bartlett
 * February 29, 2020
 * Assignment 5.1
 * Bellevue University
 * TextBookSort.java
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class TextBookSort {
    public static void main (String[] args){
        // declare Scanner to get user input
        Scanner input = new Scanner(System.in);
        // create TextBook object array with 5 instances filled
        TextBook textBook[] = {
                new TextBook("Boyle", "Corporate Computer Security", 672, "9780133545197", 200.75),
                new TextBook("Richardson", "RESTful Web APIs", 408, "9781449358068", 44.99),
                new TextBook("Hahn", "Express in Action", 256, "9781617292422", 39.99),
                new TextBook("Smith", "Elementary Information Security", 866, "9781284055931", 208.50),
                new TextBook("Kim", "Fundamentals of Information Systems Security", 548, "9781284116458", 104.00)
        };
        // Display menu for user to select what they want array sorted by
        System.out.println("Sort Text Books By:\n1. Author\n2. Title\n3. Page Count\n4. ISBN\n5. Price");
        System.out.print("Enter the number for the sort you want: ");
        int sortBy = input.nextInt();
        // call sortBooks method to sort array
        sortBooks(textBook, sortBy);
    }

    private static void sortBooks(TextBook[] books, int sortBy){
        // declare variable for use in sorting
        int smallest;
        // declare a temp TextBook object to use in sorting
        TextBook temp;
        // for loop to sort array and resets the smallest variable when moving onto next object
        for(int i = 0; i < books.length; i++){
            smallest = i;
            // nested for loop to continue onto next field of object
            for(int j = i; j < books.length; j++){
                // declare TextBook object called current to use when sorting
                TextBook current = books[smallest];
                // switch statement based on what user chooses to have books sorted by
                switch(sortBy){
                    case 1: // sort books by author
                        String author = books[j].getAuthor();
                        if(author.compareTo(current.getAuthor()) < 0)
                            smallest = j;
                        break;
                    case 2: // sort books by title
                        String title = books[j].getTitle();
                        if (title.compareTo(current.getTitle()) < 0)
                            smallest = j;
                        break;
                    case 3: // sort books by page count
                        int pageCount = books[j].getPageCount();
                        if(pageCount < current.getPageCount())
                            smallest = j;
                        break;
                    case 4: // sort books by isbn
                        String isbn = books[j].getIsbn();
                        if(isbn.compareTo(current.getIsbn()) < 0)
                            smallest = j;
                        break;
                    case 5: // sort books by price
                        double price = books[j].getPrice();
                        if(price < current.getPrice())
                            smallest = j;
                        break;
                }
            }
            // sorts smallest to the top
            temp = books[i];
            books[i] = books[smallest];
            books[smallest] = temp;
        }
        System.out.println();
        // display labels for the columns
        System.out.printf("Author\t\t\t\t\t\tTitle\t\t\t\t\t\t\t  Page Count\t   ISBN\t\t\t  Price");
        // call printBooks method to display results of sort
        printBooks(books);
    }

    // print method to display array
    private static void printBooks(TextBook[] books){
        // declare NumberFormat for currency output of prices
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println();
        // for loop to go through and display all elements of all objects
        for (int i = 0; i < books.length; i++) {
            TextBook book = books[i];
            System.out.print(padRight(book.getAuthor(), 15));
            System.out.print(padRight(book.getTitle(), 50));
            System.out.print(book.getPageCount());
            System.out.print("       " + padRight(book.getIsbn(), 16));
            System.out.println("  " + currency.format(book.getPrice()));
        }
    }
    // padRight method to format display to be more readable
    private static String padRight(String str, int n) {
        // for loop adds spaces to the right of the string to make the string lengths all the same when displaying
        for (int i = str.length(); i < n; i++) {
            str += ' ';
        }
        return str;
    }
}
