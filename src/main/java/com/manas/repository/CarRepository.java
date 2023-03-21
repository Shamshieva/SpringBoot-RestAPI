package com.manas.repository;

import com.manas.dto.reponse.ResponseCarsPage;
import com.manas.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select new com.manas.dto.reponse.ResponseCarsPage(c.brand) from Car c where c.owner.id=:userId")
    List<ResponseCarsPage> findAllUserCars(Long userId);

}
