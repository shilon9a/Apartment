package GUI;

import GUI.JPanel.AbstractPanel;
import GUI.JPanel.LoginPanel;
import GUI.JPanel.MainPanel;

import javax.swing.*;
import java.awt.*;

public class ApartmentGui extends JFrame {

    private static final Dimension SCREENSIZE=Toolkit.getDefaultToolkit().getScreenSize();
    private static final int WIDTH=800;
    private static final int HEIGHT=600;
    private JFrame jFrame;


    public ApartmentGui(){
        jFrame=new JFrame("公寓信息管理");
        jFrame.setLayout(null);
        jFrame.setBounds(SCREENSIZE.width/2-WIDTH/2,SCREENSIZE.height/2-HEIGHT/2,WIDTH,HEIGHT);

        //添加登陆界面
        AbstractPanel login=new LoginPanel(new JPanel(),jFrame);
        JPanel loginPanel=login.initPanel();
        jFrame.add(loginPanel);

        //添加主界面
        AbstractPanel main=new MainPanel(new JPanel(),jFrame);
        JPanel mainPanel=main.initPanel();
        jFrame.add(mainPanel);


        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }


}
