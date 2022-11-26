package dao;

import entity.User;

public interface UserDao {
    public User queryUserByUserName(User user);
}
