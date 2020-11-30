package com.noirix.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

public class ApplicationBeans {

  // @Bean
 //public Cars getCar() {
 //    return Cars.builder()
 //            .id(1L)
 //            .model("Tesla Model S")
 //            .price(110000D)
 //            .creationYear(2019)
 //            .color("red")
 //            .build();
  // }
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

 //  @Bean
 //  public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
 //          .select()
 //          .apis(RequestHandlerSelectors.any())
 //          .paths(PathSelectors.any())
 //          .build(); }


//   @Bean
//   public DataSource hikariDataSource (DatabaseConfig databaseConfig){
//       HikariDataSource hikariDataSource = new HikariDataSource();
//       hikariDataSource.setJdbcUrl(databaseConfig.getUrl());
//       hikariDataSource.setDriverClassName(databaseConfig.getDriverName());
//       hikariDataSource.setUsername(databaseConfig.getLogin());
//       hikariDataSource.setPassword(databaseConfig.getPassword());
//       return hikariDataSource;
//   }

}

