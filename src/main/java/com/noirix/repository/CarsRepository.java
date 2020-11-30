package com.noirix.repository;

import com.noirix.domain.Cars;
import com.noirix.domain.User;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends CrudRepository <Long, Cars>{

    List<Cars> search (String query);


}
