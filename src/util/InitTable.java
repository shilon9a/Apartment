package util;

import GUI.JTable.ApartmentTable;
import entity.Apartment;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class InitTable {
    public static void Init(List<Apartment> apartmentList){
        DefaultTableModel tableModel=ApartmentTable.getInstance(DefaultTableModel.class);
        //首先需要清空所有的数据
        tableModel.getDataVector().removeAllElements();
        try {
            Object[][] date=TableContext.getContext(apartmentList);
            for(int i=0;i<apartmentList.size();i++){
                tableModel.addRow(date[i]);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
