package GUI.Operation.Add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton extends JButton {
    private static JButton button;
    private JPanel panel;
    private Dialog addDialog;

    public AddButton(JPanel jPanel){
        this.panel=jPanel;
    }

    public JButton initAddButton(){
        button=new JButton("添加");
        button.setBounds(panel.getWidth()/10*9,panel.getHeight()/8,50,50);
        button.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog=AddDialog.initAddDialog();
            }
        });

        return button;
    }

    public static JButton getInstance(){
        return button;
    }

}
