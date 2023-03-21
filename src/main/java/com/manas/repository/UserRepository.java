package com.manas.repository;

import com.manas.dto.reponse.ResponseCarsPage;
import com.manas.dto.reponse.UserProfile;
import com.manas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select case when count (u) > 0 then true else false end from User u where u.role='ADMIN'")
    Boolean existsByAdmin();

    @Query("select new com.manas.dto.reponse.UserProfile(u.id, u.firstName, u.lastName, u.email) from User u where u.id=?1")
    Optional<UserProfile> findUserInfo(Long userId);





}