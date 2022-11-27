import entity.Apartment;
import org.testng.annotations.Test;
import service.ApartmentService;
import service.Impl.ApartmentServiceImpl;
import util.TableContext;

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
        apartmentService.removeById(new Apartment(5,null,null,null,null,null));
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


}
