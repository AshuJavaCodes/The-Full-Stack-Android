package com.spring.insta.insta.apiRepository;


import com.spring.insta.insta.dataClasses.UserData;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ApiRepository extends JpaRepository<UserData,Long> {


    //Find if a user exists in Data Base.
    @Query("SELECT s from UserData s WHERE s.userName = ?1")
    Optional<UserData> findUserByUsername(String userName);

    //Login a user if it exists in the Database. and check its Credentials.
    @Query("SELECT s from UserData s WHERE s.userName=s.userName and password=s.password")
    Optional<UserData> loginUser(String userName, String password);



}
