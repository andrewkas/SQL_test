package com.noirix.util;

import com.noirix.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationBeans {

    @Bean
    public Car getCar() {
        return Car.builder()
                .id(1L)
                .model("Tesla Model S")
                .price(110000D)
                .year(2019)
                .build();
    }
}
