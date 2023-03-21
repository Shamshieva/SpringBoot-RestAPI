package com.manas.service.serviceimpl;

import com.manas.dto.reponse.SimpleResponse;
import com.manas.dto.request.CarRequest;
import com.manas.entity.Car;
import com.manas.entity.CarInfo;
import com.manas.entity.User;
import com.manas.repository.CarInfoRepository;
import com.manas.repository.CarRepository;
import com.manas.repository.UserRepository;
import com.manas.service.CarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarInfoRepository carInfoRepository;

    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository, CarInfoRepository carInfoRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.carInfoRepository = carInfoRepository;
    }


    @Override
    public SimpleResponse saveCar(CarRequest carRequest) {
        User user = userRepository.findById(carRequest.ownerId()).orElseThrow(RuntimeException::new);

        CarInfo carInfo = new CarInfo();
        carInfo.setColor(carRequest.color());
        carInfo.setEngine(carRequest.engine());
        carInfo.setPrice(carRequest.price());
        carInfo.setYearOfIssue(carRequest.yearOfIssue());

        Car car = new Car();
        car.setBrand(carRequest.brand());
        car.setModel(carRequest.model());

        car.setCreatedAt(LocalDate.now());
        car.setCarInfo(carInfo);
        car.setOwner(user);
        user.addCar(car);
        carRepository.save(car);
//        carInfoRepository.save(carInfo); ==  @OneToOne(cascade = CascadeType.PERSIST) in Car
        return SimpleResponse.builder().status("SAVE").message("Car successfully saved!").build();
    }
}
