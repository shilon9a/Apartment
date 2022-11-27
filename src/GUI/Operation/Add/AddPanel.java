package GUI.Operation.Add;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_de;

import javax.swing.*;

public class AddPanel extends JPanel {
    private static JPanel panel;

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

    public static JPanel initPanel(JDialog jDialog){
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


}
