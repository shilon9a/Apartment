package dao.impl;

import Exception.ApartmentException;
import dao.ApartmentDao;
import entity.Apartment;
import util.SQL;

import java.math.BigDecimal;
import java.util.List;

public class ApartmentDaoImpl extends BaseDao<Apartment> implements ApartmentDao {
    @Override
    public Apartment getOne(Apartment apartment) {
        Apartment res=queryOne(apartment);
        return res;
    }

    @Override
    public boolean saveOne(Apartment apartment) {
        boolean res=save(apartment);
        if(res==false){
            return false;
        }
        return true;
    }

    @Override
    public boolean delById(Apartment apartment) {
        boolean res=removeById(apartment,apartment.getId());
        if(res==false){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateById(Apartment apartment) {
        boolean res=update(apartment);
        if(res==false){
            return false;
        }
        return true;
    }

    @Override
    public List<Apartment> getApartments(Apartment apartment) {
        List<Apartment> apartments=queryList(apartment);
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartments() {
        List<Apartment> apartments=queryAll(new Apartment());
        return apartments;
    }

    @Override
    public List<Apartment> getApartmentByNameLike(Apartment apartment) {
        return queryLike(apartment);
    }

    @Override
    public List<Apartment> getApartmentByLocationLike(Apartment apartment) {
        return queryLike(apartment);
    }

    @Override
    public List<Apartment> queryMax(Double max) {
        return Max(new Apartment(),max);
    }

    @Override
    public List<Apartment> queryMin(Double min) {
        return Min(new Apartment(),min);
    }

    @Override
    public List<Apartment> queryBetween(Double min, Double max) {
        return Between(new Apartment(),min,max);
    }
}
