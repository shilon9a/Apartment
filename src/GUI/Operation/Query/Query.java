package GUI.Operation.Query;

import GUI.JTable.ApartmentTable;
import controller.ApartmentController;
import entity.Apartment;
import util.TableContext;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Query {
    private static ApartmentController apartmentController=new ApartmentController();


    public static void queryNew(){
        DefaultTableModel tableModel=ApartmentTable.getInstance(DefaultTableModel.class);
        tableModel.getDataVector().removeAllElements();

        List<Apartment> apartmentList=apartmentController.getAll();
        Object[][] context=null;
        try {
            context=TableContext.getContext(apartmentList);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<apartmentList.size();i++){
            tableModel.addRow(context[i]);
        }


    }
}
