package GUI.Operation.Add;

import GUI.JTable.ApartmentTable;
import com.mysql.cj.xdevapi.Table;
import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_de;
import controller.ApartmentController;
import entity.Apartment;
import util.ExceptionUtil;
import util.TableContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import Exception.ApartmentException;
import Exception.CompareException;
import Exception.LengthException;

public class AddPanel extends JPanel {

    private ApartmentController apartmentController=new ApartmentController();

    private Apartment apartment;

    private static JPanel panel;

    private static JButton myAdd;

    private static JLabel apartmentLabel;
    private static JLabel locationLabel;
    private static JLabel roomNumLabel;
    private static JLabel remainingRoomLabel;
    private static JLabel avgPriceLabel;
    private static final int JLabelWidth=100;
    private static final int JLabelHeight=20;

    private static JTextField apartmentTextField;
    private static JTextField locationTextField;
    private static JTextField roomNumTextField;
    private static JTextField remainingRomTextField;
    private static JTextField avgPriceTextField;
    private static final int JTextFieldWidth=180;
    private static final int JTextFieldHeight=50;

    public  JPanel initPanel(JDialog jDialog){
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,jDialog.getWidth(),jDialog.getHeight());

        //添加apartment
        initApartment(panel);
        panel.add(apartmentTextField);
        panel.add(apartmentLabel);

        //添加location
        initLocation(panel);
        panel.add(locationTextField);
        panel.add(locationLabel);

        //添加房间数
        initRoomNum(panel);
        panel.add(roomNumTextField);
        panel.add(roomNumLabel);

        //添加剩余房间数
        initRemainingRoom(panel);
        panel.add(remainingRomTextField);
        panel.add(remainingRoomLabel);

        //添加平均价格
        initAvgPrice(panel);
        panel.add(avgPriceTextField);
        panel.add(avgPriceLabel);

        //添加添加按钮
        initButton();
        panel.add(myAdd);

        //监听添加事件
        myAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ans=JOptionPane.showConfirmDialog(panel, "确认添加");

                    if(ans==JOptionPane.YES_OPTION){
                        add();
                        jDialog.dispose();
                    } else if (ans==JOptionPane.NO_OPTION || ans==JOptionPane.CANCEL_OPTION) {
                        jDialog.dispose();
                    }
                } catch (CompareException ex) {
                    JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);

                }catch (LengthException ex){
                    JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel,"请输入正确的数字","提醒",JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });


        return panel;
    }

    public static void initApartment(JPanel panel){
        apartmentTextField=new JTextField();
        apartmentTextField.setBounds(panel.getWidth()/3,panel.getHeight()/6,JTextFieldWidth,JTextFieldHeight);
        apartmentTextField.setVisible(true);

        apartmentLabel=new JLabel("公寓名称");
        apartmentLabel.setBounds(panel.getWidth()/16,apartmentTextField.getY()+apartmentTextField.getHeight()/2- JLabelHeight/2,JLabelWidth,JLabelHeight);
        apartmentLabel.setVisible(true);

    }

    public static void initLocation(JPanel panel){
        locationTextField=new JTextField();
        locationTextField.setBounds(panel.getWidth()/3,panel.getHeight()/6*2,JTextFieldWidth,JTextFieldHeight);
        locationTextField.setVisible(true);

        locationLabel=new JLabel("地理位置");
        locationLabel.setBounds(panel.getWidth()/16,locationTextField.getY()+ locationTextField.getHeight()/2-JLabelHeight/2,JLabelWidth,JLabelHeight);
        locationLabel.setVisible(true);
    }

    public static void initRoomNum(JPanel panel){
        roomNumTextField=new JTextField();
        roomNumTextField.setBounds(panel.getWidth()/3,panel.getHeight()/6*3,JTextFieldWidth,JTextFieldHeight);
        roomNumTextField.setVisible(true);
        roomNumLabel=new JLabel("共有房间数");
        roomNumLabel.setBounds(panel.getWidth()/16,roomNumTextField.getY()+ roomNumTextField.getHeight()/2-JLabelHeight/2,JLabelWidth,JLabelHeight);
        roomNumLabel.setVisible(true);
    }

    public static void initRemainingRoom(JPanel panel){
        remainingRomTextField=new JTextField();
        remainingRomTextField.setBounds(panel.getWidth()/3,panel.getHeight()/6*4,JTextFieldWidth,JTextFieldHeight);
        remainingRomTextField.setVisible(true);

        remainingRoomLabel=new JLabel("剩余房间数");
        remainingRoomLabel.setBounds(panel.getWidth()/16,remainingRomTextField.getY()+ remainingRomTextField.getHeight()/2-JLabelHeight/2,JLabelWidth,JLabelHeight);
        remainingRoomLabel.setVisible(true);
    }

    public static void initAvgPrice(JPanel panel){
        avgPriceTextField=new JTextField();
        avgPriceTextField.setBounds(panel.getWidth()/3,panel.getHeight()/6*5,JTextFieldWidth,JTextFieldHeight);
        avgPriceTextField.setVisible(true);

        avgPriceLabel=new JLabel("平均月租价格");
        avgPriceLabel.setBounds(panel.getWidth()/16,avgPriceTextField.getY()+ avgPriceTextField.getHeight()/2-JLabelHeight/2,JLabelWidth,JLabelHeight);
        avgPriceLabel.setVisible(true);
    }

    public static void initButton(){
        myAdd=new JButton("添加");
        myAdd.setBounds(panel.getWidth()/3,panel.getHeight()/12,40,40);
    }

    public  void add() throws NumberFormatException,LengthException,CompareException{
        apartment=new Apartment(null,
                apartmentTextField.getText(),
                locationTextField.getText(),
                Integer.valueOf(roomNumTextField.getText().toString()),
                Integer.valueOf(remainingRomTextField.getText().toString()),
                new BigDecimal(avgPriceTextField.getText().toString()));
        ExceptionUtil.comparePriceLen(new BigDecimal(avgPriceTextField.getText().toString()));
        ExceptionUtil.compareRoomNum(Integer.valueOf(remainingRomTextField.getText().toString()),Integer.valueOf(roomNumTextField.getText().toString()));
        if(!apartmentController.save(apartment)){
            throw new ApartmentException("保存失败");
        }
        List<Apartment> apartmentList=null;
        apartmentList=apartmentController.getAll();
        Object[][] context=null;
        try {
            context=TableContext.getContext(apartmentList);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        DefaultTableModel tableModel=ApartmentTable.getInstance(DefaultTableModel.class);
        tableModel.getDataVector().removeAllElements();
        for(int i=0;i<apartmentList.size();i++){
            tableModel.addRow(context[i]);
        }
    }


}
