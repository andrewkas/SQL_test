package com.noirix.repository.impl;

import com.noirix.domain.Cars;
import com.noirix.domain.Gender;
import com.noirix.domain.User;
import com.noirix.repository.CarsColumns;
import com.noirix.repository.CarsRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.noirix.repository.CarsColumns.*;

@Repository
@Primary
public class CarsRepositoryJdbcTemplateImpl implements CarsRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarsRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    private Cars getCarsRowMapper(ResultSet rs, int i) throws SQLException {
        Cars cars = new Cars();
        cars.setId(rs.getLong(ID));
        cars.setModel(rs.getString(MODEL));
        cars.setCreationYear(rs.getInt(CREATION_YEAR));
        cars.setUserId(rs.getLong(USER_ID));
        cars.setPrice(rs.getDouble(PRICE));
        cars.setColor(rs.getString(COLOR));

        return cars;
    }


    @Override
    public List<Cars> search(String query) {
        return jdbcTemplate.query("select * from m_cars where model like ?", new Object[]{query}, this::getCarsRowMapper);
    }

    @Override
    public Cars save(Cars entity) {
        final String createQuery = "insert into m_cars ( model, creation_year, user_id, price, color) " +
                "values ( :model, :creationYear, :userId, :price, :color);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", entity.getId());
        params.addValue("model", entity.getModel());
        params.addValue("creationYear", entity.getCreationYear());
        params.addValue("userId", entity.getUserId());
        params.addValue("price", entity.getPrice());
        params.addValue("color", entity.getColor());

        namedParameterJdbcTemplate.update(createQuery, params, keyHolder, new String[]{"id"});

        long createdCarsId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(createdCarsId);
    }

    @Override
    public List<Cars> findAll() {
        return jdbcTemplate.query("select * from m_cars",this::getCarsRowMapper);
    }

    @Override
    public Cars findById(Long carsId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("carsId", carsId);

        return namedParameterJdbcTemplate.queryForObject("select * from m_cars where id=:carsId",mapSqlParameterSource, this::getCarsRowMapper);
    }

    @Override
    public Optional<Cars> findOne(Long key) {

        return Optional.ofNullable(findById(key));

    }



    @Override
    public Cars update(Cars object) {
        final String findByIdObject = "update m_cars " +
                "set " +
                "model = ?,  " +
                "creation_year = ?,  " +
                "user_id = ?,  " +
                "price = ?,  " +
                "color = ?  " +
                "where id = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", object.getId());
        params.addValue("model", object.getModel());
        params.addValue("creationYear", object.getCreationYear());
        params.addValue("userId", object.getUserId());
        params.addValue("price", object.getPrice());
        params.addValue("color", object.getColor());

        namedParameterJdbcTemplate.update(findByIdObject, params, keyHolder, new String[]{"id"});

        long updatedCarsId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(updatedCarsId);
    }


    @Override
    public Long delete(Cars entity) {
        final String findByIdQuery = "delete from m_cars where id = :carsId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("carsId", entity.getId());


        long deletedCarsId = namedParameterJdbcTemplate.update(findByIdQuery, params);



        return deletedCarsId;
    }
}
