# book-inventory-system
A java-based book inventory system

# Input
- User selects options (1-4) from a menu for inventory management
- If option 1 is selected, the user enters the number of book copies and the price of each book

# Processing
- Uses a do-while loop with a try/catch exception to handle the menu
- Uses a switch statement to select from options (1-4)
Option 1: Uses a Book array and a for-loop to get the number of book copies and price, then writes the book information to the file.
Option 2: Uses a Scanner to read each line from the file and display them in order.
Option 3: Reads each line from the file, splits the information using the commas, converts the number of copies and price into numbers, then creates a Book object and calculates the total value.
Option 4: Exits the program and displays a thank you message.

# Output: 
- Informs user that the file has been created
- Displays the information stored in the file
- Shows the total value of all the books
- Thank you message when user exits the program

# Author
Huzaifa Memon

