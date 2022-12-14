package GUI.Operation.Update;

import javax.swing.*;

public class UpdateDialog extends JDialog {
    private static JDialog updateDialog;
    private static final int DialogWidth=300;
    private static final int DialogHeight=500;

    public static JDialog initUpdateDialog(){
        updateDialog=new UpdateDialog();
        updateDialog.setSize(DialogWidth,DialogHeight);
        updateDialog.setModal(true);

        //添加panel
        UpdatePanel panel=new UpdatePanel();
        JPanel addPanel=panel.initPanel(updateDialog);
        updateDialog.add(addPanel);


        updateDialog.setResizable(false);
        updateDialog.setVisible(true);
        return updateDialog;
    }


}
