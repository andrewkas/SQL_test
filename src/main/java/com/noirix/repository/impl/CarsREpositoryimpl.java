package com.noirix.repository.impl;

import com.noirix.domain.Cars;
import com.noirix.domain.Gender;
import com.noirix.domain.User;
import com.noirix.repository.CarsRepository;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.noirix.repository.impl.UserRepositoryImpl.*;
import static com.noirix.util.DatabasePropertiesReader.*;

/*public class CarsREpositoryimpl implements CarsRepository {
    private static String ID = "id";
    private static String MODEL = "model";
    private static String CREATION_YEAR = "creation_year";
    private static String USER_ID = "user_id";
    private static String PRICE = "price";
    private static String COLOR = "color";





    @Override
    public List<Cars> search(String query) {
        return null;
    }

    @Override
    public Cars save(Cars object) {
        return null;
    }

    @Override
    public List<Cars> findAll() {
        final String findAllQuery = "select * from m_cars order by id";
         List <Cars> result = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet rs;

        try {
            Class.forName(POSTRGES_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }

        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);

        try {
            connection = DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
            statement = connection.createStatement();
            rs = statement.executeQuery(findAllQuery);

            while (rs.next()) {
                Cars cars = new Cars();
                cars.setId(rs.getLong(ID));
                cars.setModel(rs.getString(MODEL));
                cars.setCreation_year(rs.getInt(CREATION_YEAR));
                cars.setUser_id(rs.getLong(USER_ID));
                cars.setPrice(rs.getDouble(PRICE));
                cars.setColor(rs.getString(COLOR));


                result.add(cars);
            }

            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }



    @Override
    public Cars findById(Long key) {
        return null;
    }

    @Override
    public Optional<Cars> findOne(Long key) {
        return Optional.empty();
    }

    @Override
    public Cars update(Cars object) {
        return null;
    }

    @Override
    public Long delete(Cars object) {
        return null;
    }
}
*/