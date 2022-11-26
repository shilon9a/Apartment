package GUI.JPanel;


import controller.UserController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends AbstractPanel {

    private UserController userController=new UserController();


    private JLabel username;
    private JLabel password;
    private JLabel msg;
    private static final int jLabelWidth=50;
    private static final int jLabelHeight=50;

    private JTextField usernameText;
    private JPasswordField passwordField;
    private static final int jTextFieldWidth=200;
    private static final int jTextFieldHeight=40;

    private JButton loginButton;
    private static final int buttonWidth=50;
    private static final int buttonHeight=50;



    public LoginPanel(JPanel panel,JFrame jFrame) {
        super(panel,jFrame);
    }
    @Override
    public JPanel initPanel() {
        panel.setLayout(null);
        panel.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());

        //添加背景
        /*panel.setBackground(Color.cyan);*/

        //添加用户名Label
        initUsernameJLabel();
        panel.add(username);

        //添加密码Label
        initPasswordJLabel();
        panel.add(password);

        //添加msg
        initMsg();
        panel.add(msg);

        //添加用户名Text
        initUsernameText();
        panel.add(usernameText);

        //添加密码Text
        initPasswordField();
        panel.add(passwordField);

        //添加登陆按钮
        initLoginButton();
        panel.add(loginButton);
        //监听按钮
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName=usernameText.getText();
                String passWord= passwordField.getText();
                if(userController.login(userName,passWord)){
                    panel.setVisible(false);
                }else{
                    msg.setVisible(true);
                }

            }
        });


        panel.setVisible(true);
        return panel;
    }

    private void initUsernameJLabel(){
        username=new JLabel("用户名");
        username.setBounds(jFrame.getWidth()/3-jLabelWidth/2,jFrame.getHeight()/4-jLabelHeight/2,jLabelWidth,jLabelHeight);
    }
    private void initPasswordJLabel(){
        password=new JLabel("密码");
        password.setBounds(jFrame.getWidth()/3-jLabelWidth/2,jFrame.getHeight()/3-jLabelHeight/2,jLabelWidth,jLabelHeight);
    }
    private void initMsg(){
        msg=new JLabel("用户名或密码错误");
        msg.setBounds(jFrame.getWidth()/2,jFrame.getHeight()/2,1000,20);
        msg.setVisible(false);
    }
    private void initUsernameText(){
        usernameText=new JTextField();
        usernameText.setBounds(jFrame.getWidth()/2-jLabelWidth/2,jFrame.getHeight()/4-jLabelHeight/2,jTextFieldWidth,jTextFieldHeight);
    }
    private void initPasswordField(){
        passwordField=new JPasswordField();
        passwordField.setBounds(jFrame.getWidth()/2-jLabelWidth/2,jFrame.getHeight()/3-jLabelHeight/2,jTextFieldWidth,jTextFieldHeight);
    }
    private void initLoginButton(){
        loginButton=new JButton("登陆");
        loginButton.setBounds(jFrame.getWidth()/2,jFrame.getHeight()/2,buttonWidth,buttonHeight);
    }

}
