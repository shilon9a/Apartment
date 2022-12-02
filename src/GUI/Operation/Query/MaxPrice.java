package GUI.Operation.Query;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import Exception.NegativeException;

public class MaxPrice {
    private static JTextField max;
    private JPanel panel;
    private static final int width=100;
    private static final int height=40;

    public MaxPrice(JPanel jPanel){
        panel=jPanel;
    }

    public JTextField initMaxTextField(){
        max=new JTextField("最高价格");
        max.setBounds(panel.getWidth()/10*4,panel.getHeight()/10*2,width,height);
        max.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                max.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(max.getText().equals("")){
                    max.setText("最高价格");
                }else{
                    try{
                        Double.valueOf(max.getText());
                        if(Double.valueOf(max.getText())<0){
                            throw new NegativeException("价格应大于0");
                        }
                    }catch(NumberFormatException exception){
                        JOptionPane.showMessageDialog(panel,"请输入正确的数字","提醒",JOptionPane.INFORMATION_MESSAGE);
                    }catch (NegativeException ex){
                        JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        max.setVisible(true);
        return max;
    }

    public static JTextField getInstance(){
        return max;
    }
}
