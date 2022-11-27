package GUI.JPanel;

import GUI.JTable.ApartmentTable;
import GUI.Operation.Add.AddButton;
import entity.Apartment;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class MainPanel extends AbstractPanel{

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
        JTable table=apartmentTable.initTable();
        JTableHeader header=table.getTableHeader();
        panel.add(header);
        panel.add(table);

        //添加增加按钮
        AddButton addButton=new AddButton(panel);
        JButton button=addButton.initAddButton();
        panel.add(button);


        panel.setVisible(false);
        return panel;
    }
}
