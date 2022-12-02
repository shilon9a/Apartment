import GUI.JTable.ApartmentTable;
import controller.ApartmentController;
import dao.ApartmentDao;
import dao.impl.ApartmentDaoImpl;
import entity.Apartment;
import org.testng.annotations.Test;
import service.ApartmentService;
import service.Impl.ApartmentServiceImpl;
import util.TableContext;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class serviceTest {
    private ApartmentService apartmentService=new ApartmentServiceImpl();

    @Test
    public void queryService(){
        Apartment apartment=apartmentService.queryOne(new Apartment(2,null,null,null,null,null));
        System.out.println(apartment);
    }

    @Test
    public void updateService(){
        boolean b=apartmentService.update(new Apartment(2,"2公寓更新更新版1","陕西科技大学",200,0,new BigDecimal(200)));
        Apartment apartment=apartmentService.queryOne(new Apartment(2,null,null,null,null,null));
        System.out.println(apartment);
    }

    @Test
    public void saveService(){
        apartmentService.save(new Apartment(null,"345公寓","陕西科技大学",200,0,new BigDecimal(200)));
        Apartment apartment=apartmentService.queryOne(new Apartment(5,null,null,null,null,null));
        System.out.println(apartment);
    }

    @Test
    public void delService(){
        apartmentService.removeById(5);
        List<Apartment> apartments=apartmentService.queryAll();
        apartments.stream().forEach(item->{
            System.out.println(item);
        });


    }

    @Test
    public void testYear(){
        System.out.println(Calendar.YEAR);
    }

    @Test
    public void testTableContext() throws IllegalAccessException {
        List<Apartment> apartments=apartmentService.queryAll();
        Object[][] context =TableContext.getContext(apartments);
        System.out.println(context);
    }

    @Test
    public void testInstance(){
        JTable table1=ApartmentTable.getInstance(JTable.class);
        JTable table2=ApartmentTable.getInstance(JTable.class);
        if(table1==table2){
            System.out.println(true);
        }else {
        System.out.println(false);
        }
    }

    @Test
    public void testLike(){
        ApartmentDao apartmentDao=new ApartmentDaoImpl();
        List<Apartment> apartments=apartmentDao.getApartmentByLocationLike(new Apartment(null,null,"京",null,null,null));

        System.out.println(apartments);
    }

    @Test
    public void testLikecon(){
        ApartmentController apartmentController=new ApartmentController();
        List<Apartment> apartments=apartmentController.queryByNameOrLocation("京");
        apartments.stream().forEach(item->{
            System.out.println(item);
        });
    }


    @Test
    public void aop(){
    }

    @Test
    public void testLen(){
        String str="            ";
        String temp=str.trim();
        System.out.println(str==null);
        System.out.println(str.equals("       "));
        System.out.println(str.length());
        System.out.println(temp.length());
    }

}
