package GUI.Operation.Query;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import Exception.NegativeException;

public class MinPrice {
    private static JTextField min;
    private JPanel panel;
    private static final int width=100;
    private static final int height=40;

    public MinPrice(JPanel jPanel){
        panel=jPanel;
    }

    public JTextField initMinTextField(){
        min=new JTextField("最低价格");
        min.setBounds(panel.getWidth()/10,panel.getHeight()/10*2,width,height);
        min.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                min.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (min.getText().equals("")) {
                    min.setText("最低价格");
                }else {
                    try {
                        Double.valueOf(min.getText());
                        if(Double.valueOf(min.getText())<0){
                            throw new NegativeException("价格应大于0");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel,"请输入正确的数字","提醒",JOptionPane.INFORMATION_MESSAGE);
                    }catch (NegativeException ex){
                        JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        min.setVisible(true);
        return min;
    }

    public static JTextField getInstance(){
        return min;
    }

}
