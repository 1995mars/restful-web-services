package com.mars.rest.webservices.restfulwebservices.service;

import com.mars.rest.webservices.restfulwebservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();
    private static int count = 4;
    static {
        userList.add(new User(1,"Adam1", new Date()));
        userList.add(new User(2,"Adam2", new Date()));
        userList.add(new User(3,"Adam3", new Date()));
        userList.add(new User(4,"Adam4", new Date()));

    }

    public List<User> findAll(){
        return userList;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++count);
        }
        userList.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: userList){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterable = userList.iterator();

        while (iterable.hasNext()){
            User user = iterable.next();
            if(user.getId() == id){
                iterable.remove();
                return  user;
            }
        }

        return null;
    }

}
