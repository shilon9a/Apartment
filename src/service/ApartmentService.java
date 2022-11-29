package service;

import entity.Apartment;

import java.util.List;

public interface ApartmentService {
    public Apartment queryOne(Apartment apartment);

    public boolean save(Apartment apartment);

    public boolean removeById(Integer id);

    public boolean update(Apartment apartment);

    public List<Apartment> queryList(Apartment apartment);

    public List<Apartment> queryAll();

    public List<Apartment> queryByName(String name);

    public List<Apartment> queryByLocation(String location);

    public List<Apartment> queryMin(Double min);

    public List<Apartment> queryMax(Double max);

    public List<Apartment> queryBetween(Double min,Double max);
}
