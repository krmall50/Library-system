package Library.Actions;

import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.User;
import java.awt.print.Book;
import java.util.Scanner;

public class AddBook implements IOOperation {

    @Override
    public void oper(Database database, User user) {

        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        String name = s.next();
        if(database.getBook(name)>-1){
            System.out.println("There is a book with this name!");
            user.menu(database,user);
            return;
        }else{
            book.setName(name);
            System.out.println("Enter book author: ");
            book.setAuthor(s.next());
            System.out.println("Enter book publisher: ");
            book.setPublisher(s.next());
            System.out.println("Enter book collection address: ");
            book.setAdress(s.next());
            System.out.println("Enter book qty: ");
            book.setQty(s.nextInt());
            System.out.println("Enter book price: ");
            book.setPrice(s.nextDouble());
            System.out.println("Enter borrowing copies: ");
            book.setBrwcopies(s.nextInt());
            s.close();
            database.AddBook(book);
            System.out.println("Book added successfully");
        }



    }
}
