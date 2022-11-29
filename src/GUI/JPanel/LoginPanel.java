package GUI.JPanel;


import GUI.Operation.Add.AddButton;
import GUI.Operation.Del.DelButton;
import GUI.Operation.Query.MaxPrice;
import GUI.Operation.Query.MinPrice;
import GUI.Operation.Update.UpDateButton;
import controller.ApartmentController;
import controller.UserController;
import util.InitTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends AbstractPanel {

    private UserController userController=new UserController();
    private static JPanel mainPanel;


    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JLabel msgLabel;
    private static final int jLabelWidth=50;
    private static final int jLabelHeight=50;

    private static JTextField usernameTextField;
    private static JPasswordField passwordField;
    private static final int jTextFieldWidth=200;
    private static final int jTextFieldHeight=40;

    private static JButton loginButton;

    private static JButton visitorButton;
    private static final int buttonWidth=200;
    private static final int buttonHeight=50;

    ApartmentController apartmentController=new ApartmentController();

    public LoginPanel(JPanel panel,JFrame jFrame) {
        super(panel,jFrame);
    }
    @Override
    public JPanel initPanel() {
        panel.setLayout(null);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());

        //添加背景
        /*panel.setBackground(Color.cyan);*/

        //添加用户名Label
        initUsernameJLabel();
        panel.add(usernameLabel);

        //添加密码Label
        initPasswordJLabel();
        panel.add(passwordLabel);

        //添加msg
        initMsg();
        panel.add(msgLabel);

        //添加用户名Text
        initUsernameText();
        panel.add(usernameTextField);

        //添加密码Text
        initPasswordField();
        panel.add(passwordField);

        //添加登陆按钮
        initLoginButton();
        panel.add(loginButton);

        //添加游客登陆按钮
        initVisitorButton();
        panel.add(visitorButton);

        //监听按钮
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName=usernameTextField.getText();
                String passWord= passwordField.getText();
                try {
                    if(userController.login(userName,passWord)){
                        panel.setVisible(false);
                        mainPanel.setVisible(true);
                        //隐藏添加按钮
                        AddButton.getInstance().setVisible(true);
                        //隐藏删除按钮隐
                        DelButton.getInstance().setVisible(true);
                        //隐藏修改按钮
                        UpDateButton.getInstance().setVisible(true);

                        JTextField maxPrice= MaxPrice.getInstance();
                        maxPrice.setText("最高价格");
                        JTextField minPrice= MinPrice.getInstance();
                        minPrice.setText("最低价格");

                        InitTable.Init(apartmentController.getAll());
                    }else{
                        msgLabel.setVisible(true);
                    }
                } catch (Exception ex) {
                    msgLabel.setVisible(true);
                }


            }
        });

        visitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                mainPanel.setVisible(true);
                InitTable.Init(apartmentController.getAll());
                //隐藏添加按钮
                AddButton.getInstance().setVisible(false);
                //隐藏删除按钮隐
                DelButton.getInstance().setVisible(false);
                //隐藏修改按钮
                UpDateButton.getInstance().setVisible(false);

                JTextField maxPrice= MaxPrice.getInstance();
                maxPrice.setText("最高价格");
                JTextField minPrice= MinPrice.getInstance();
                minPrice.setText("最低价格");

            }
        });




        panel.setVisible(true);
        return panel;
    }

    private void initUsernameJLabel(){
        usernameLabel=new JLabel("用户名");
        usernameLabel.setBounds(frame.getWidth()/3-jLabelWidth/2,frame.getHeight()/4-jLabelHeight/2,jLabelWidth,jLabelHeight);
    }
    private void initPasswordJLabel(){
        passwordLabel=new JLabel("密码");
        passwordLabel.setBounds(frame.getWidth()/3-jLabelWidth/2,frame.getHeight()/3-jLabelHeight/2,jLabelWidth,jLabelHeight);
    }
    private void initMsg(){
        msgLabel=new JLabel("用户名或密码错误");
        msgLabel.setBounds(frame.getWidth()/2,frame.getHeight()/2,1000,20);
        msgLabel.setVisible(false);
    }
    private void initUsernameText(){
        usernameTextField=new JTextField();
        usernameTextField.setBounds(frame.getWidth()/2-jLabelWidth/2,frame.getHeight()/4-jLabelHeight/2,jTextFieldWidth,jTextFieldHeight);
    }
    private void initPasswordField(){
        passwordField=new JPasswordField();
        passwordField.setBounds(frame.getWidth()/2-jLabelWidth/2,frame.getHeight()/3-jLabelHeight/2,jTextFieldWidth,jTextFieldHeight);
    }
    private void initLoginButton(){
        loginButton=new JButton("管理员登陆");
        loginButton.setBounds(frame.getWidth()/3,frame.getHeight()/2,buttonWidth,buttonHeight);
    }
    private void initVisitorButton(){
        visitorButton=new JButton("游客登陆");
        visitorButton.setBounds(frame.getWidth()/3*2,frame.getHeight()/2,buttonWidth,buttonHeight);
    }

    public void getMainPanel(JPanel panel){
        mainPanel=panel;
    }

    public static <T> T getInstance(String str){
        if(str.equals("usernameTextField")){
            return (T)usernameTextField;
        }
        else if(str.equals("passwordField")){
            return (T)passwordField;
        }else if(str.equals("msgLabel")){
            return (T)msgLabel;
        }
        return null;
    }

}
