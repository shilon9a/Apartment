package GUI.JTable;

import controller.ApartmentController;
import entity.Apartment;
import service.ApartmentService;
import service.Impl.ApartmentServiceImpl;
import util.TableContext;

import javax.swing.*;
import java.util.List;

public class ApartmentTable extends JTable {
    private JTable apartmentTable;
    private JPanel jPanel;
    public ApartmentTable(JPanel jPanel){
        this.jPanel=jPanel;
    }

    public JTable initTable(){
        String[] titles={"公寓名","地理位置","共有房间数","剩余房间数","平均月租价格"};

        ApartmentService apartmentService=new ApartmentServiceImpl();
        List<Apartment> apartments=apartmentService.queryAll();

        Object[][] context = new Object[0][];
        try {
            context = TableContext.getContext(apartments);
        } catch (IllegalAccessException e) {
            System.out.println("内容转换失败");
        }

        apartmentTable=new JTable(context,titles){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        apartmentTable.setLayout(null);
        apartmentTable.setBounds(jPanel.getWidth()/10,jPanel.getHeight()/4,jPanel.getWidth()/10*8, jPanel.getHeight()/5*3);
        apartmentTable.setVisible(true);
        return apartmentTable;
    }


}
