package service.Impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean login(User user) {
        //如果存在用户名则返回一个实例，如果不存在则返回null
        User tempUser=userDao.queryUserByUserName(user);
        if(tempUser==null){
            //实际上是用户名就错了
            throw new NullPointerException("用户名或密码错误");
        }
        //用户名存在且密码正确
        if(tempUser.getPassword()!=null && tempUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }


}
