package com.getpostapi.GetPostSpringBootApi.repository;


import com.getpostapi.GetPostSpringBootApi.dataclass.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiRepository extends JpaRepository<UserData,Long> {



    @Query("SELECT s FROM UserData s WHERE s.username = ?1")
    Optional<UserData> findUserByUsername(String userName);



}
