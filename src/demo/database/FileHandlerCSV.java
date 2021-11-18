package demo.database;

import demo.domain.Controller;
import demo.domain.User;
import demo.ui.UserInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileHandlerCSV implements Database {

    UserInterface ui = new UserInterface();
    User user;

    @Override
    public void saveUser(User user) {
        File file = new File("database/file.csv");
        try{
            PrintStream ps = new PrintStream(file);
            ps.append(user.toCSVString());
            ps.close();
        } catch (FileNotFoundException e){
            ui.printMessage("Cannot add user");
        }
    }


    @Override
    public User findUser(String name, String password) {
        File file = new File("database/file.csv");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] userLine = sc.nextLine().split(";");
                if (userLine[0].equals(name) && userLine[1].equals(password)) {
                    return user.createUserToFile(name, password);
                }
            }
        } catch (FileNotFoundException e){
            e.getMessage();
        }
        return null;
    }
}
