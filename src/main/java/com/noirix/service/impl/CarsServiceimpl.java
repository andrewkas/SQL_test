package com.noirix.service.impl;

import com.noirix.domain.Cars;
import com.noirix.repository.CarsRepository;
import com.noirix.service.CarsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceimpl implements CarsService {

    private CarsRepository carsRepository;

    public CarsServiceimpl(CarsRepository carsRepository){
        this.carsRepository=carsRepository;
    }

    @Override
    public List<Cars> findAll() {
        return carsRepository.findAll();
    }

    @Override
    public Cars save(Cars cars) {
        return carsRepository.save(cars);
    }

    @Override
    public Cars findById(Long userId) {
        return carsRepository.findById(userId);
    }

    @Override
    public List<Cars> search(String query) {
        return carsRepository.search(query);
    }

    @Override
    public Optional<Cars> findOne(Long key) {
        return carsRepository.findOne(key);
    }

    @Override
    public Cars update(Cars object) {
        return carsRepository.update(object);
    }

    @Override
    public Long delete(Cars entity) {
        return carsRepository.delete(entity);
    }
}
