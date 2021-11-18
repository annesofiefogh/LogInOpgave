package demo.database;

import demo.domain.User;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class FileHandlerStub implements Database {

    private ArrayList<User> users = new ArrayList<>();

    public User findUser(String name, String password){

        for (int i = 0; i < users.size(); i++) {
            User temp = users.get(i);
            if (temp.getName().equals(name) && temp.getPassword().equals(password)){
                return temp;
            }
        }
        return null;
        //return new User("John Smith", "1234");
    }

    public void saveUser(User user){
        users.add(user);
    }

}
