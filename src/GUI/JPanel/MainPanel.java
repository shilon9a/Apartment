package GUI.JPanel;

import GUI.JTable.ApartmentTable;
import GUI.Operation.Add.AddButton;
import GUI.Operation.Del.DelButton;
import GUI.Operation.Query.MaxPrice;
import GUI.Operation.Query.MinPrice;
import GUI.Operation.Query.QueryButton;
import GUI.Operation.Query.QueryText;
import GUI.Operation.Update.UpDateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends AbstractPanel{

    private JPanel loginPanel;

    public MainPanel(JPanel jPanel, JFrame jFrame) {
        super(jPanel, jFrame);
    }

    @Override
    public JPanel initPanel() {
        panel.setLayout(null);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setBackground(Color.cyan);

        //添加表格
        ApartmentTable apartmentTable=new ApartmentTable(panel);
        JScrollPane scrollPane=ApartmentTable.getInstance(JScrollPane.class);
        ApartmentTable.initTableModel();
        panel.add(scrollPane);

        //添加增加按钮
        AddButton addButton=new AddButton(panel);
        JButton button=addButton.initAddButton();
        panel.add(button);

        //添加删除按钮
        DelButton delButton=new DelButton(panel);
        JButton del=delButton.initDelButton();
        panel.add(del);

        //添加更新按钮
        UpDateButton upDateButton=new UpDateButton(panel);
        JButton update=upDateButton.initUpdateButton();
        panel.add(update);

        //添加查询按钮和查询窗口
        QueryButton queryButton=new QueryButton(panel);
        JButton query=queryButton.initQueryButton();
        QueryText queryText=new QueryText(panel);
        JTextField text=queryText.initQueryText();
        panel.add(query);
        panel.add(text);

        //添加两个价格窗口
        MinPrice minPrice=new MinPrice(panel);
        JTextField min=minPrice.initMinTextField();
        MaxPrice maxPrice=new MaxPrice(panel);
        JTextField max=maxPrice.initMaxTextField();
        panel.add(min);
        panel.add(max);

        //添加返回按钮
        JButton returnButton=returnButton();
        panel.add(returnButton);


        panel.setVisible(false);
        return panel;
    }

    public JButton returnButton(){
        JButton button=new JButton("返回");
        button.setBounds(panel.getWidth()/10*9,panel.getHeight()/22,50,50);
        button.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                loginPanel.setVisible(true);
                JPasswordField passwordField=LoginPanel.getInstance("passwordField");
                JTextField usernameTextField=LoginPanel.getInstance("usernameTextField");
                JLabel msgLabel=LoginPanel.getInstance("msgLabel");

                passwordField.setText("");
                usernameTextField.setText("");
                msgLabel.setVisible(false);

            }
        });

        return button;
    }

    public void getLoginPanel(JPanel panel){
        loginPanel=panel;
    }

}
