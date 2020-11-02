package com.noirix.util;

import com.noirix.domain.Car;
import com.noirix.domain.Cars;
import com.noirix.repository.impl.CarsRepositoryJdbcTemplateImpl;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ApplicationBeans {

   @Bean
   public Cars getCar() {
       return Cars.builder()
               .id(1L)
               .model("Tesla Model S")
               .price(110000D)
               .creationYear(2019)
               .color("red")
               .build();
   }
 //   @Bean
 //   public Cars getCar2() {
 //       return Cars.builder()
 //               .id(1L)
 //               .model("Tesla Model X")
 //               .price(150000D)
 //               .creation_year(2020)
 //               .color("black")
 //               .build();

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource hikariDataSource (DatabaseConfig databaseConfig){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(databaseConfig.getUrl());
        hikariDataSource.setDriverClassName(databaseConfig.getDriverName());
        hikariDataSource.setUsername(databaseConfig.getLogin());
        hikariDataSource.setPassword(databaseConfig.getPassword());
        return hikariDataSource;
    }

}

