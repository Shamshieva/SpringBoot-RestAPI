package com.manas.controller;


import com.manas.dto.reponse.SimpleResponse;
import com.manas.dto.request.CarRequest;
import com.manas.service.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public SimpleResponse saveCar(@RequestBody CarRequest carRequest){
        return carService.saveCar(carRequest);
    }
}






