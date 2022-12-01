package GUI.Operation.Del;

import GUI.JTable.ApartmentTable;
import GUI.Operation.Query.Query;
import controller.ApartmentController;
import entity.Apartment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class DelButton extends JButton {
    private static JButton delButton;
    private JPanel panel;
    private ApartmentController apartmentController=new ApartmentController();

    private static final int ButtonWidth=50;
    private static final int ButtonHeight=50;

    public DelButton(JPanel jPanel){
        panel=jPanel;
    }

    public JButton initDelButton(){
        delButton=new JButton("删除");
        delButton.setBounds(panel.getWidth()/10*8,panel.getHeight()/8,ButtonWidth,ButtonHeight);

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table=ApartmentTable.getInstance(JTable.class);
                if(table.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(panel,"请至少选中一行","提醒",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int option=JOptionPane.showConfirmDialog(panel,"确认删除");

                    //点击确认
                    if (option==JOptionPane.YES_OPTION) {
                        DefaultTableModel tableModel=ApartmentTable.getInstance(DefaultTableModel.class);
                        table=ApartmentTable.getInstance(JTable.class);

                        int[] waitDelRow=table.getSelectedRows();
                        for(int i=0;i<waitDelRow.length;i++){
                            //获取到行数据
                            Object data = tableModel.getDataVector().elementAt(waitDelRow[i]);

                            Vector vector=(Vector) data;
                            //获取id
                            Integer id = (Integer)vector.elementAt(0);

                            apartmentController.removeById(id);

                            Query.queryNew();
                        }
                    }else if(option==JOptionPane.CANCEL_OPTION || option==JOptionPane.NO_OPTION){
                        //什么都不做
                    }
                }

            }
        });

        delButton.setVisible(true);
        return delButton;
    }

    public static JButton getInstance(){
        return delButton;
    }



}
