package com.getpostapi.GetPostSpringBootApi.controllers;


import com.getpostapi.GetPostSpringBootApi.dataclass.UserData;
import com.getpostapi.GetPostSpringBootApi.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test/v1")
public class ApiController {

    private ApiService apiService;


    @Autowired
    public ApiController(ApiService apiService){
        this.apiService = apiService;

    }



    @GetMapping("/getUsers")
    public List<UserData> getUsers(){
        return apiService.getAllStudent();
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserData userData){
        apiService.saveUser(userData);
    }





}
