/**********************************
 * Project: Book Inventory System
 * Programmer: Huzaifa Memon
 * Date: April 28, 2025
 * Program: BookInventorySystem.java
 ***********************************/

package bookinventorysystem;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class BookInventorySystem {

    public static void main(String[] args) throws InterruptedException {
        //Scanner
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        
        //Decimal Format
        DecimalFormat twoDigit = new DecimalFormat("0.00");
        
        //File
        File nf = new File("bookinventory.txt"); 
        
        //variables
        int choice = 0;
        double total = 0;
        PrintWriter pw;
        String line;
        String[] bookInventory;
        
        //Books
        Book[] books = {
            new Book("Between Shades of Gray", 0, 0),
            new Book("Maus", 0, 0),
            new Book("Medicine Walk", 0, 0),
            new Book("The Great Gatsby", 0, 0),
            new Book("The Hate U Give", 0, 0)
        };
        
        //start of do-while loop
        do{
            System.out.println("Welcome to Milton's Book Inventory System!");
            System.out.println("Please choose an option from the following menu:");
            System.out.println("1. Create an inventory file\n" + "2. Display Inventory data from file"
            + "\n3. Calculate total value of all books in the inventory\n" + "4. Exit Inventory Management System.");
            System.out.println("Please enter the number based off your choice:");
            
            //start of try for the main menu
            try{
                choice = scanN.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Input error: Please make sure you enter an integer");
            }//end of catch
            
            switch(choice){
                case 1:
                    //start of try for asking user book prices and copies
                    try{ 
                        //printwriter
                        pw = new PrintWriter(nf);
                        
                        //for loop for each book
                        for (Book book : books) {
                            System.out.println("How many copies of " + book.getName() + " are in stock?");
                            book.setCopies(scanN.nextInt());
                            System.out.println("What is the price of each copy of " + book.getName() + "?");
                            book.setPrice(scanN.nextDouble());
                            pw.println(book);
                        
                            //delay for 1 second for efficiency
                            Thread.sleep(1000);
                        }//end of for loop
                        
                        //closing the printwriter
                        pw.close();
                        System.out.println("File has been created.");
                    }
                    catch(IOException e)
                {
                    System.out.println("File error: " + e.getMessage());
                }//end of catch
                    break;
                case 2: 
                    //start of try for reading the file
                    try{
                        //scanner for reading file
                        scanS = new Scanner(nf);
                        
                        //while loop for reading every line of the file for each book
                        while(scanS.hasNext()){
                        line = scanS.nextLine();
                            System.out.println(line);
                        }//end of while loop
                        
                        //delay for 3 seconds for efficiency
                        Thread.sleep(3000);
                    }//end of try
                    catch(IOException e)
                {
                    System.out.println("File error: " + e.getMessage()); 
                }//end of catch   
                    //closing Scanner
                    scanS.close();  
                    break;   
                    
                case 3:
                    //start of try for calculating the total value of all books
                    try{
                        total = 0;
                        scanS = new Scanner(nf);
                        while(scanS.hasNext()){
                            line = scanS.nextLine();
                            bookInventory = line.split(",");
                        
                            //converting the Strings to Integers
                            int numofBooks = Integer.parseInt(bookInventory[1]);
                        
                            //converting the Strings to Doubles
                            double price = Double.parseDouble(bookInventory[2]);
                            
                            //create book Object using file information
                            Book book = new Book(
                                bookInventory[0],
                                numofBooks,
                                price   
                            );
                        
                            //calculating the total value
                            total += book.calcValue();
                            }//end of while loop
                            System.out.println("The total value of all the books in stock is " + twoDigit.format(total));
                    
                        //delay for 1 second for efficiency
                        Thread.sleep(1000);
                        
                        }//end of try
                        catch(IOException e)
                    {
                        System.out.println("File error: " + e.getMessage());
                    }//end of catch
                    
                        //closing Scanner
                        scanS.close(); 
                        break;
                case 4:
                    //for user exitting the program
                    System.out.println("Thank you for using the inventory system.");
                    
                    //delay for 500ms for efficiency
                    Thread.sleep(500);
                        
                    System.out.println("Have a good day!");
                    break;
                    
                default:
                    //if user enters the wrong value
                    System.out.println("Invalid option, please select a number from the menu.");
                    
                    //delay for 1 second for efficiency
                    Thread.sleep(1000);
                        
                    break;
            }//end of switch
            
        }while(choice!=4);
        
    }//main
    
}//class
