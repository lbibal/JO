package com.example.jo.Athlete.Persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.jo.Athlete.Persistence.Athlete;
import java.util.Optional;

@Repository
public interface AthleteRepository extends CrudRepository<Athlete,Long> {
    Optional<Athlete> findById(long id);
    Iterable<Athlete> findAll();
}
