package Library.Database;

import Library.Users.User;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
    private Connection conn;
    public Connection ConnectToDB() {
        try {
            // Connect to the PostgresSQL database
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
        } catch (
                SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (conn != null){System.out.println("Good");}
        return conn;
    }
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> usernames = new ArrayList<String>();
    public void addUser(User s){
        users.add(s);
        usernames.add(s.getName());
    }
    public int login(String number, String email){
        int n = -1;
        for(User s : users){
            if(s.getNumber().matches(number) && s.getEmail().matches(email)){
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }
    public User getUser(int n){
        return users.get(n);
    }
}
