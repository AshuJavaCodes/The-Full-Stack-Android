package com.spring.insta.insta.apiService;


import com.spring.insta.insta.apiRepository.ApiRepository;
import com.spring.insta.insta.dataClasses.BasicResponseClass;
import com.spring.insta.insta.dataClasses.LoginBody;
import com.spring.insta.insta.dataClasses.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Service
public class ApiService {


    private ApiRepository apiRepository;


    @Autowired
    public ApiService(ApiRepository apiRepository){
        this.apiRepository =apiRepository;

    }
    //Methods to get Data from the Database.

    //Method to check if the Login credentials are correct or not
    public BasicResponseClass loginUser(LoginBody loginBody){
        Optional<UserData> loginBodyOptional = apiRepository.loginUser(loginBody.getUserName(), loginBody.getPassword());
        if(loginBodyOptional.isPresent()){
            return new BasicResponseClass("success","200","Login Successfully");
        }
        return new BasicResponseClass("fail","200","Username/password is invalid");

    }



    //Method to check if user Exists in the Database for login.
    public Map<String, String> saveUser(UserData userData){
        Map<String, String> responseMap = new HashMap<>();
        Optional<UserData> userDataOptional =  apiRepository.findUserByUsername(userData.getUserName());
        if(userDataOptional.isPresent()){

            responseMap.put("status","fail");
            responseMap.put("code","400");
            responseMap.put("message","User Already Exists");
            return responseMap;


        }else {
            apiRepository.save(userData);
            responseMap.put("status","success");
            responseMap.put("code","200");
            responseMap.put("message","Sign up Successfully");
            return responseMap;
        }

    }
    //Method to get all the user in the database.
    public List<UserData> getAllUser(){

        return apiRepository.findAll();

    }







}
