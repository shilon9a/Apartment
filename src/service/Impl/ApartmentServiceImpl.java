package service.Impl;

import dao.ApartmentDao;
import dao.impl.ApartmentDaoImpl;
import entity.Apartment;
import service.ApartmentService;

import java.util.List;

public class ApartmentServiceImpl implements ApartmentService {
    private ApartmentDao apartmentDao=new ApartmentDaoImpl();

    @Override
    public Apartment queryOne(Apartment apartment) {
        return apartmentDao.getOne(apartment);
    }

    @Override
    public boolean save(Apartment apartment) {
        return apartmentDao.saveOne(apartment);
    }

    @Override
    public boolean removeById(Integer id) {
        Apartment apartment=new Apartment(id,null,null,null,null,null);
        return apartmentDao.delById(apartment);
    }

    @Override
    public boolean update(Apartment apartment) {
        return apartmentDao.updateById(apartment);
    }

    @Override
    public List<Apartment> queryList(Apartment apartment) {
        return apartmentDao.getApartments(apartment);
    }

    @Override
    public List<Apartment> queryAll() {
        return apartmentDao.getAllApartments();
    }

    @Override
    public List<Apartment> queryByName(String name) {
        return apartmentDao.getApartmentByNameLike(new Apartment(null,name,null,null,null,null));
    }

    @Override
    public List<Apartment> queryByLocation(String location) {
        return apartmentDao.getApartmentByLocationLike(new Apartment(null,null,location,null,null,null));
    }

    @Override
    public List<Apartment> queryMin(Double min) {
        return apartmentDao.queryMin(min);
    }

    @Override
    public List<Apartment> queryMax(Double max) {
        return apartmentDao.queryMax(max);
    }

    @Override
    public List<Apartment> queryBetween(Double min, Double max) {
        return apartmentDao.queryBetween(min,max);
    }
}
