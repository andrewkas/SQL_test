package com.noirix.util;

import com.noirix.domain.Car;
import com.noirix.domain.Cars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationBeans {

    @Bean
    public Cars getCar() {
        return Cars.builder()
                .id(1L)
                .model("Tesla Model S")
                .price(110000D)
                .creation_year(2019)
                .color("red")
                .build();
    }
}
