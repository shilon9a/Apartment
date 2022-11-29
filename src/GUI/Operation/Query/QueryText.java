package GUI.Operation.Query;

import javax.swing.*;

public class QueryText extends JTextField {
    private static JTextField textField;
    private JPanel panel;

    private static final int textWidth=200;
    private static final int textHeight=40;

    public QueryText(JPanel jPanel){
        panel=jPanel;
    }

    public JTextField initQueryText(){
        textField=new JTextField();
        textField.setBounds(panel.getWidth()/10,panel.getHeight()/10,textWidth,textHeight);

        textField.setVisible(true);
        return textField;
    }

    public static JTextField getInstance(){
        return textField;
    }


}
