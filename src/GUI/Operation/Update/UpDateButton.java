package GUI.Operation.Update;

import GUI.JTable.ApartmentTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpDateButton extends JButton {

    private static JButton updateButton;

    private JPanel panel;

    private JDialog updateDialog;

    public UpDateButton(JPanel jPanel){
        panel=jPanel;
    }

    public JButton initUpdateButton(){
       updateButton=new JButton("修改");
       updateButton.setBounds(panel.getWidth()/10*7,panel.getHeight()/8,50,50);
       updateButton.setVisible(true);

       updateButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JTable table= ApartmentTable.getInstance(JTable.class);
               if(table.getSelectedRow()==-1){
                   JOptionPane.showMessageDialog(panel,"请选择要修改的数据","提醒",JOptionPane.INFORMATION_MESSAGE);
               }
               else{
                   updateDialog=UpdateDialog.initUpdateDialog();
               }
           }
       });

       return updateButton;
    }

    public static JButton getInstance(){
        return updateButton;
    }

}
