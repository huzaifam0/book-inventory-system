/**********************************
 * Project: Book Inventory System
 * Programmer: Huzaifa Memon
 * Date: April 28, 2025
 * Program: Book.java
 ***********************************/
package bookinventorysystem;

public class Book{
    //Fields
    private String bookName; 
    private int bookCopies;
    private double bookPrice;
    
    public Book(){
        bookName = "";
        bookCopies = 0;
        bookPrice = 0.0;
    }
    
    public Book(String n, int c, double p){
        bookName = n;
        bookCopies = c;
        bookPrice = p;
    }
    
    public void setName(String t){
        bookName = t;
    }

    public void setCopies(int c){
        bookCopies = c;
    }

    public void setPrice(double p){
        bookPrice = p;
    }

    public String getName(){
        return bookName;
    }

    public int getCopies(){
        return bookCopies;
    }

    public double getPrice(){
        return bookPrice;
    }
    
    public double calcValue(){
        return bookCopies * bookPrice;
    }
    
    public String toString(){
        String bookInfo = bookName + "," + bookCopies + "," + bookPrice;
        return bookInfo;
    }
    
}//class
