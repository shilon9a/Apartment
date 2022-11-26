package service.Impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean login(User user) {
        User tempUser=userDao.queryUserByUserName(user);
        if(tempUser.getPassword()!=null && tempUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }


}
