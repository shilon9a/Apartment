package controller;

import entity.User;
import service.Impl.UserServiceImpl;
import service.UserService;

public class UserController {
    private UserService userService=new UserServiceImpl();

    public boolean login(String username,String password){
        User user =new User(null,username,password,null);
        return userService.login(user);
    }

}
