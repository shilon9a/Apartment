package GUI.Operation.Update;

import GUI.JTable.ApartmentTable;
import GUI.Operation.Query.Query;
import controller.ApartmentController;
import entity.Apartment;
import util.ExceptionUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Vector;
import Exception.CompareException;
import Exception.LengthException;
import Exception.NegativeException;

public class UpdatePanel extends JPanel {

    private ApartmentController apartmentController=new ApartmentController();

    private  Apartment apartment;

    private static JPanel panel;

    private static JButton myUpdate;
    private Integer DateId;
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

    public static void initApartment(JPanel panel){
        apartmentTextField=new JTextField(){
            @Override
            public boolean isEditable() {
                return false;
            }
        };
        apartmentTextField.setBounds(panel.getWidth()/3,panel.getHeight()/6,JTextFieldWidth,JTextFieldHeight);
        apartmentTextField.setVisible(true);

        apartmentLabel=new JLabel("公寓名称");
        apartmentLabel.setBounds(panel.getWidth()/16,apartmentTextField.getY()+apartmentTextField.getHeight()/2- JLabelHeight/2,JLabelWidth,JLabelHeight);
        apartmentLabel.setVisible(true);

    }

    public static void initLocation(JPanel panel){
        locationTextField=new JTextField(){
            @Override
            public boolean isEditable() {
                return false;
            }
        };
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
        myUpdate=new JButton("修改");
        myUpdate.setBounds(panel.getWidth()/3,panel.getHeight()/12,40,40);
    }

    public JPanel initPanel(JDialog jDialog){
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

        //添加修改按钮
        initButton();
        panel.add(myUpdate);

        //初始化内容
        initField();


        //监听修改事件
        myUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ans=JOptionPane.showConfirmDialog(panel, "修改");

                    if(ans==JOptionPane.YES_OPTION){
                        update();
                        Query.queryNew();
                        jDialog.dispose();
                    } else if (ans==JOptionPane.NO_OPTION || ans==JOptionPane.CANCEL_OPTION) {
                        jDialog.dispose();
                    }
                } catch (CompareException ex) {
                    JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                }catch (LengthException ex){
                    JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(panel,"请输入正确的数字","提醒",JOptionPane.INFORMATION_MESSAGE);
                }catch (NegativeException ex){
                    JOptionPane.showMessageDialog(panel,ex.getMessage(),"提醒",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });


        return panel;
    }



    public void initField(){
        DefaultTableModel tableModel=ApartmentTable.getInstance(DefaultTableModel.class);
        JTable table=ApartmentTable.getInstance(JTable.class);
        int num=table.getSelectedRow();

        Object date=tableModel.getDataVector().elementAt(table.getSelectedRow());
        Vector vector=(Vector) date;
        DateId=(Integer) vector.get(0);
        apartment=apartmentController.getOne(DateId);

        apartmentTextField.setText(apartment.getApartmentName());
        locationTextField.setText(apartment.getLocation());
        roomNumTextField.setText(apartment.getRoomNum().toString());
        remainingRomTextField.setText(apartment.getRemainingRoom().toString());
        avgPriceTextField.setText(apartment.getAvgPrice().toString());
    }

    public void update()throws NumberFormatException,LengthException,CompareException,NegativeException {
        apartment=new Apartment();
        apartment.setId(DateId);
        apartment.setApartmentName(apartmentTextField.getText());
        apartment.setRoomNum(Integer.valueOf(roomNumTextField.getText()));
        apartment.setRemainingRoom(Integer.valueOf(remainingRomTextField.getText()));
        apartment.setAvgPrice(new BigDecimal(avgPriceTextField.getText()));

        apartmentController.update(apartment);
    }


}
