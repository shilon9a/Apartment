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
    public boolean removeById(Apartment apartment) {
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
}
