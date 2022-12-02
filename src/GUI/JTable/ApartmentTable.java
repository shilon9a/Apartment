package GUI.JTable;

import entity.Apartment;
import service.ApartmentService;
import service.Impl.ApartmentServiceImpl;
import util.TableContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ApartmentTable extends JTable {

    //设置static为唯一table
    private static JTable apartmentTable;

    private static DefaultTableModel tableModel;

    private static JScrollPane scrollPane;

    private static JPanel jPanel;

    public ApartmentTable(JPanel jPanel){
        this.jPanel=jPanel;
        init();
    }

    public void init(){
        tableModel=new DefaultTableModel();
        tableModel.setColumnCount(6);
        String[] titles={"id","公寓名","地理位置","共有房间数","剩余房间数","平均月租价格"};
        tableModel.setColumnIdentifiers(titles);

        apartmentTable=new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        apartmentTable.setLayout(null);
        apartmentTable.setShowGrid(true);
        apartmentTable.setBounds(jPanel.getWidth()/10,jPanel.getHeight()/4,jPanel.getWidth()/10*8, jPanel.getHeight()/5*3);
        apartmentTable.removeColumn(apartmentTable.getColumnModel().getColumn(0));
        apartmentTable.getTableHeader().setReorderingAllowed(false);
        apartmentTable.setVisible(true);

        scrollPane=new JScrollPane(apartmentTable);
        scrollPane.setBounds(jPanel.getWidth()/10,jPanel.getHeight()/4,jPanel.getWidth()/10*8, jPanel.getHeight()/5*3);
        scrollPane.setVisible(true);
    }

    public void initTableModel(){
        ApartmentService apartmentService=new ApartmentServiceImpl();
        List<Apartment> apartments=apartmentService.queryAll();

        Object[][] context = new Object[apartments.size()][6];
        try {
            context = TableContext.getContext(apartments);
        } catch (IllegalAccessException e) {
            System.out.println("内容转换失败");
        }
        for(int i=0;i< apartments.size();i++){
            tableModel.addRow(context[i]);
        }
        apartmentTable.setModel(tableModel);
    }


    /*public JTable initTable(){
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
    }*/

    /**
     * 返回全局唯一的实例
     * @return
     */
    public static <T> T getInstance(Class<?> clazz){
        if(clazz==JTable.class){
            return (T) apartmentTable;
        }
        if(clazz==DefaultTableModel.class){
            return (T)tableModel;
        }
        if(clazz==JScrollPane.class){
            return (T)scrollPane;
        }
        return null;
    }


}
