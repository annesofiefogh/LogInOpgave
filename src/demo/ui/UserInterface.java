package demo.ui;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void menu(){
        printMessage("""
                (1) Create user
                (2) Login
                (3) Save user to file
                (4) Find user in file
                (0) Exit program""");
    }

    public String userInput(){
        return scanner.nextLine();
    }

    public void printMessage(String s) {
        System.out.print(s);
    }
}
