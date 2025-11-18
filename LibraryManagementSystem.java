
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Book{

    String title;
    String author;
    boolean isIssued;
    String issuedTo;
    String issuedDate;

    public Book(String title, String author, boolean isIssued, String issuedTo, String issuedDate){
        
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
        this.issuedTo = issuedTo;
        this.issuedDate = issuedDate;
    }
}


public class LibraryManagementSystem {

    public Map<Integer, Book> books = new HashMap<>();

    public void addBook(int bookId, String title, String author){
        books.put(bookId, new Book(title, author, false, null, null));
        System.out.println("Book added successfully");
    }

    public void issueBook( int bookId,String userName,String issuedDate){
        if(books.containsKey(bookId)){
            books.get(bookId).isIssued = true;
            books.get(bookId).issuedTo = userName;
            books.get(bookId).issuedDate = issuedDate;
            System.out.println("Book issued successfully");
        }
        else{
            System.out.println("Book not found");
        }
    }

    public void returnBook(int bookId){
        if(books.containsKey(bookId)){
            books.get(bookId).isIssued = false;
            books.get(bookId).issuedTo = null;
            books.get(bookId).issuedDate = null;
            System.out.println("Book returned successfully");
        }
        else{
            System.out.println("Book not found");
        }
    }

    
    public void listAvailableBooks(){
        for(Map.Entry<Integer,Book> entry : books.entrySet()){
            if(!entry.getValue().isIssued){
                System.out.println("\nBook ID: " + entry.getKey());
                System.out.println("Book Title: " + entry.getValue().title);
                System.out.println("Book Author: " + entry.getValue().author);
            }
        }
    }


    public static void main(String[] args){
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int bookIdCounter = 0;

        while(true){
            System.out.println("*********Library Management System*********");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. List Available Books");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("*********Add Book*********");
                    sc.nextLine();
                    System.out.println("Enter the book title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the book author: ");
                    String author = sc.nextLine();
                    
                    lms.addBook(bookIdCounter++, title, author);
                    break;

                case 2:

                    System.out.println("*********Issue Book*********");
                    System.out.println("Enter the book id:");
                    int issuedbookId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the username: ");
                    String userName = sc.nextLine();
                    System.out.println("Enetr the issue date:");
                    String issuedDate = sc.nextLine();

                    lms.issueBook(issuedbookId,userName,issuedDate);
                    break;
                    
                    
                case 3:
                    System.out.println("*********Return Book*********");
                    System.out.println("Enter the book id:");
                    int returnbookId = sc.nextInt();
                    sc.nextLine();
                    lms.returnBook(returnbookId);
                    break;

                case 4:
                    lms.listAvailableBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
           
        }
       
        
    }
}
