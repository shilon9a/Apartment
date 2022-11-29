package controller;

import entity.Apartment;
import service.ApartmentService;
import service.Impl.ApartmentServiceImpl;
import sun.security.krb5.internal.APRep;

import java.util.ArrayList;
import java.util.List;

public class ApartmentController {
    ApartmentService apartmentService=new ApartmentServiceImpl();

    /**
     * 添加
     * @param apartment
     * @return
     */
    public boolean save(Apartment apartment){
        return apartmentService.save(apartment);
    }

    /**
     * 查询所有的数据
     * @return
     */
    public List<Apartment> getAll(){
        return apartmentService.queryAll();
    }

    /**
     * 通过id删除对应的数据
     * @param id
     * @return
     */
    public boolean removeById(Integer id){
        return apartmentService.removeById(id);
    }

    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    public Apartment getOne(Integer id){
        return apartmentService.queryOne(new Apartment(id,null,null,null,null,null));
    }

    /**
     * 更新数据
     * @param apartment
     * @return
     */
    public boolean update(Apartment apartment){
        return apartmentService.update(apartment);
    }


    /**
     * 根据条件查询
     * @param apartment
     * @return
     */
    public List<Apartment> getList(Apartment apartment){
        return apartmentService.queryList(apartment);
    }

    /**
     * 根据传入的字符串查询公寓名或地址中有哪些有相同的
     * @param str
     * @return
     */
    public List<Apartment> queryByNameOrLocation(String str){
        List<Apartment> nameList=apartmentService.queryByName(str);
        List<Apartment> locationList=apartmentService.queryByLocation(str);

        locationList.stream().forEach(location->{
            if(!nameList.contains(location)){
                nameList.add(location);
            }
        });

        return nameList;
    }

    public List<Apartment> queryPrice(Double min,Double max){
        List<Apartment> apartments=null;
        if(min!=null && max==null){
            apartments=apartmentService.queryMin(min);
        } else if (min==null && max!=null) {
            apartments=apartmentService.queryMax(max);
        } else if (min!=null && max!=null) {
            apartments=apartmentService.queryBetween(min,max);
        }

        return apartments;
    }

}
