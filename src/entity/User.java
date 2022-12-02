package entity;

import Exception.NullException;

public class User {
    private Integer id;
    private String username;
    private String password;

    /**
     * 1是管理员
     * 0是普通用户
     * -1是被注销的账号
     */
    private Integer role;

    public User() {
    }

    public User(Integer id, String username, String password, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.trim().length()==0){
            throw new NullException("用户名不为空");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.trim().length()==0){
            throw new NullException("密码不为空");
        }
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
