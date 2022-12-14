package GUI.Operation.Add;

import javax.swing.*;

public class AddDialog extends JDialog {
    private static JDialog addDialog;
    private static final int DialogWidth=300;
    private static final int DialogHeight=500;

    public static JDialog initAddDialog(){
        addDialog=new AddDialog();
        addDialog.setSize(DialogWidth,DialogHeight);
        addDialog.setModal(true);
        addDialog.setLayout(null);

        //添加panel
        AddPanel panel=new AddPanel();
        JPanel addPanel=panel.initPanel(addDialog);
        addDialog.add(addPanel);


        addDialog.setResizable(false);
        addDialog.setVisible(true);
        return addDialog;
    }


}
