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


    /**
     *
     * @param apartment
     * @return
     */
    public List<Apartment> getApartmentByNameLike(Apartment apartment);

    /**
     * 地址信息的模糊查询
     * @param apartment
     * @return
     */
    public List<Apartment> getApartmentByLocationLike(Apartment apartment);

    /**
     * 最大值查询
     * @param max
     * @return
     */
    public List<Apartment> queryMax(Double max);

    /**
     * 最小值查询
     * @param min
     * @return
     */
    public List<Apartment> queryMin(Double min);

    /**
     * 范围查询
     * @param min
     * @param max
     * @return
     */
    public List<Apartment> queryBetween(Double min,Double max);
}
