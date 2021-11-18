package demo.database;

import demo.domain.User;

public interface Database {

    void saveUser(User user);

    User findUser(String s1, String s2);

}
