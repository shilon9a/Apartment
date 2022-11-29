package GUI.Operation.Query;

import GUI.JTable.ApartmentTable;
import controller.ApartmentController;
import entity.Apartment;
import util.ExceptionUtil;
import util.InitTable;
import util.TableContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Exception.CompareException;

public class QueryButton extends JButton {

    ApartmentController apartmentController=new ApartmentController();
    private JButton queryButton;

    private JPanel panel;

    private JTextField min;
    private JTextField max;

    public QueryButton(JPanel jPanel){
        panel=jPanel;
    }

    public JButton initQueryButton(){
        queryButton=new JButton("查询");
        queryButton.setBounds(panel.getWidth()/10*6,panel.getHeight()/8,50,50);

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField=QueryText.getInstance();
                String text=textField.getText();
                List<Apartment> apartmentList=null;
                List<Apartment> ans=new ArrayList<>();
                try {
                    if(!MaxPrice.getInstance().getText().equals("最高价格") || !MinPrice.getInstance().getText().equals("最低价格")){
                        if(MaxPrice.getInstance().getText().equals("最高价格")){
                            Double min=Double.valueOf(MinPrice.getInstance().getText());
                            apartmentList=apartmentController.queryPrice(min,null);
                        }else if(MinPrice.getInstance().getText().equals("最低价格")){
                            Double max=Double.valueOf(MaxPrice.getInstance().getText());
                            apartmentList=apartmentController.queryPrice(null,max);
                        }else{
                            ExceptionUtil.compareMaxAndMinPrice(Double.valueOf(MinPrice.getInstance().getText()),Double.valueOf(MaxPrice.getInstance().getText()));
                            apartmentList=apartmentController.queryPrice(Double.valueOf(MinPrice.getInstance().getText()),Double.valueOf(MaxPrice.getInstance().getText()));
                        }
                        if(!text.equals("")){
                            text=text.trim();
                            for(Apartment apartment:apartmentList){
                                if(apartment.getApartmentName().contains(text)){
                                    ans.add(apartment);
                                }
                                if(apartment.getLocation().contains(text)){
                                    ans.add(apartment);
                                }
                            }
                        }else{
                            ans=apartmentList;
                        }
                    } else if(!text.equals("")){
                        text=text.trim();
                        ans=apartmentController.queryByNameOrLocation(text);
                    }else{
                        ans=apartmentController.getAll();
                    }
                    InitTable.Init(ans);
                }catch (CompareException ex){
                    JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel,"请输入正确的数字","提醒",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        queryButton.setVisible(true);
        return queryButton;
    }


}
