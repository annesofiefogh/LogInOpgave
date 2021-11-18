package demo.domain;

import demo.database.FileHandlerCSV;
import demo.database.FileHandlerStub;
import demo.ui.UserInterface;

public class Controller {

    private UserInterface ui = new UserInterface();
    private FileHandlerStub fileHandler = new FileHandlerStub();
    private FileHandlerCSV fhCSV = new FileHandlerCSV();
    private User selectedUser = null;
    private boolean isRunning = true;


    public void start(){
    while(isRunning){
            ui.menu();
            switch (ui.userInput()){
                case "0" -> exit();
                case "1" -> createUser();
                case "2" -> logIn();
                case "3" -> saveUser();
                case "4" -> findUser();
                }
        }
    }

    public void findUser(){
        ui.printMessage("Type user name to find a specific user: ");
        String findName = ui.userInput();
        ui.printMessage("Type user password to find a specific user: ");
        String findPW = ui.userInput();
        selectedUser = fhCSV.findUser(findName,findPW);
    }

    public void saveUser(){
        fhCSV.saveUser(selectedUser);
    }

    public void createUser() {
        ui.printMessage("Type in user name: ");
        String name = ui.userInput();
        ui.printMessage("Type in password: ");
        String password = ui.userInput();
        User user = new User(name, password);
        fileHandler.saveUser(user);
    }

    public void logIn() {
        ui.printMessage("Type in user name: ");
        String name = ui.userInput();
        ui.printMessage("Type in password: ");
        String password = ui.userInput();
        User user = fileHandler.findUser(name, password);
        if(user != null){
            ui.printMessage("Welcome user" + name + " " +  user.getRole());
        } else {
            ui.printMessage("User not found");
        }
    }

    public void userInfo(){
        ui.printMessage(selectedUser.toString());
    }

    public void exit(){
        isRunning = false;
    }

}
