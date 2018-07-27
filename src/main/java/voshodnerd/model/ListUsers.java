package voshodnerd.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ListUsers {
    List<User> ls = new ArrayList<>();

    public  void addUser(User user) {
        ls.add(user);
    }

    public  void deleteUser(User user) {
        ls.remove(user );


    }

    public  List<User> getListUsers() {return  ls;}

}
