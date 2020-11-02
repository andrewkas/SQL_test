package com.noirix.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Data



public class Cars {
    private Long id;
    private String model;
    private Integer creationYear;
    private Long userId;
    private Double price;
    private String color;


}
