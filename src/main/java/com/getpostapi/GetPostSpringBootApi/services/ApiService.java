package com.getpostapi.GetPostSpringBootApi.services;


import com.getpostapi.GetPostSpringBootApi.dataclass.UserData;
import com.getpostapi.GetPostSpringBootApi.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class ApiService {


    private ApiRepository apiRepository;


    @Autowired
    public ApiService(ApiRepository apiRepository){
        this.apiRepository=apiRepository;

    }


    //Get all the Users in the DataBase.
    public List<UserData> getAllStudent(){
        return apiRepository.findAll();
    }

    //Save a User in the Data Base.
    public void saveUser(UserData userData){

        Optional<UserData> userDataOptional = apiRepository.findUserByUsername(userData.getUsername());
        if(userDataOptional.isPresent()){
            throw new IllegalStateException();
        }else {
            apiRepository.save(userData);
        }




    }





}
