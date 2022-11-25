package service;

import entity.Apartment;

import java.util.List;

public interface ApartmentService {
    public Apartment queryOne(Apartment apartment);

    public boolean save(Apartment apartment);

    public boolean removeById(Apartment apartment);

    public boolean update(Apartment apartment);

    public List<Apartment> queryList(Apartment apartment);

    public List<Apartment> queryAll();
}
