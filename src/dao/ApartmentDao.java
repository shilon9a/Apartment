package dao;

import entity.Apartment;

import java.util.List;

public interface ApartmentDao {

    /**
     * 查询单个数据
     * @param apartment
     * @return
     */
    public Apartment getOne(Apartment apartment);

    /**
     * 保存数据
     * @param apartment
     * @return
     */
    public boolean saveOne(Apartment apartment);

    /**
     * 通过id删除数据
     * @param apartment
     * @return
     */
    public boolean delById(Apartment apartment);

    /**
     * 更新数据
     * @param apartment
     * @return
     */
    public boolean updateById(Apartment apartment);

    /**
     * 查询多个数据
     * @param apartment
     * @return
     */
    public List<Apartment> getApartments(Apartment apartment);

    /**
     * 查询所有的数据
     * @return
     */
    public List<Apartment> getAllApartments();


}
