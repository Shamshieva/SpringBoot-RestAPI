package com.manas.dto.request;

import com.manas.entity.User;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
public record CarRequest(
        String brand,
        String model,
        LocalDate yearOfIssue,
        Double engine,
        String color,
        Long ownerId,
        BigDecimal price
) {

}
