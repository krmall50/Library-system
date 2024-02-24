package Library.Interfaces;

import Library.Database.Database;
import Library.Users.User;

public interface IOOperation {
    public void oper(Database database, User user);
}
