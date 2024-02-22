package Library.Users;

public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
    }
    public NormalUser(String name, String email, String number){
        super(name, email, number);
    }
}
