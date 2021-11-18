package demo.domain;

public class User {
    private String name;
    private String password;
    private String role;

    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.role = "customer";
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User createUserToFile(String name, String password){
        User user = new User(name, password);
        return user;
    }

    public String toCSVString(){
        return name + ";" + password + ";" + role;
    }

    public String toString(){
        return name + " " + password + " " + role;
    }

}


