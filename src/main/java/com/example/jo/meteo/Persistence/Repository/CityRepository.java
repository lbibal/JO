package com.example.jo.meteo.Persistence.Repository;

import com.example.jo.meteo.Persistence.Entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
    Iterable<City> findAll();
}
