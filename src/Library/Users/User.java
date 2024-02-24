package Library.Users;

import Library.Database.Database;
import Library.Interfaces.IOOperation;

public abstract class User {
    protected String name;
    protected String email;
    protected String number;
    protected IOOperation[] operations;

    public User(String name){
        setName(name);
    }
    public User(String name, String email, String number){
        setName(name);
        setEmail(email);
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    abstract public void menu(Database database, User user);

}
