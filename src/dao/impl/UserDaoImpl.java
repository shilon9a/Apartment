package dao.impl;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User queryUserByUserName(User user) {
        User tempUser=new User(null, user.getUsername(), null,null);
        return queryOne(tempUser);
    }
}
