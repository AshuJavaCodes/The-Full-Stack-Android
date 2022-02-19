package com.spring.insta.insta.apiController;


import com.fasterxml.jackson.annotation.JsonView;
import com.spring.insta.insta.apiService.ApiService;
import com.spring.insta.insta.dataClasses.LoginBody;
import com.spring.insta.insta.dataClasses.UserData;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/v1")
public class LoginController {


    private ApiService apiService;


    @Autowired
    public LoginController(ApiService apiService){
        this.apiService=apiService;

    }

    @GetMapping("/login")
    public void loginUser(@RequestBody LoginBody loginBody){
        apiService.loginUser(loginBody);
    }

    @GetMapping("/getAll")
    public List<UserData> getAllUser(){

        return apiService.getAllUser();
    }


    @PostMapping("/signUpUser")
    public Map<String,String> createUser(@RequestBody UserData userData){
        //Most of the Methods in the controller dont have a returntype.
        return apiService.saveUser(userData);
    }
}
