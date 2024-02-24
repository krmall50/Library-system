package Library.Actions;

import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.User;

public class ViewBooks implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        System.out.println("View Books");
    }
}
