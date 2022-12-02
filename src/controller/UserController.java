package controller;

import entity.User;
import service.Impl.UserServiceImpl;
import service.UserService;

public class UserController {
    private UserService userService=new UserServiceImpl();

    public boolean login(String username,String password){
        User user=new User();
        user.setId(null);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(1);
        return userService.login(user);
    }

}
