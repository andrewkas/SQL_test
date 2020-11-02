package com.noirix.service;


import com.noirix.domain.Cars;

import java.util.List;
import java.util.Optional;

public interface CarsService {

        List<Cars> findAll();

        Cars save(Cars cars);

        Cars findById(Long userId);

        List<Cars> search(String query);

        Optional<Cars> findOne(Long key);

        Cars update(Cars object);

        Long delete(Cars entity);


}
