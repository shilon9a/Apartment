package GUI.Operation.Add;

import javax.swing.*;

public class AddDialog extends JDialog {
    private static JDialog addDialog;
    private static final int DialogWidth=300;
    private static final int DialogHeight=500;

    public static JDialog initAddDialog(){
        addDialog=new AddDialog();
        addDialog.setSize(DialogWidth,DialogHeight);
        addDialog.setLayout(null);

        //添加panel
        addDialog.add(AddPanel.initPanel(addDialog));


        addDialog.setResizable(false);
        addDialog.setVisible(true);
        addDialog.setDefaultCloseOperation(addDialog.EXIT_ON_CLOSE);
        return addDialog;
    }


}
