package Library.Actions;

import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.User;
import java.util.Scanner;

public class DeleteAllData implements IOOperation {

    public void oper(Database database, User user) {

        System.out.println("Are you sure that you want to delete all data?" +
                "1.Contine\n2.Main Menu");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if (i != 1) {
            database.deleteAllData();
        } else {
            user.menu(database,user);
        }

    }
}
