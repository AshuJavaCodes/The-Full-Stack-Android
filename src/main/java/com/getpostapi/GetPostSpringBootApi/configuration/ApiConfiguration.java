package com.getpostapi.GetPostSpringBootApi.configuration;


import com.getpostapi.GetPostSpringBootApi.dataclass.UserData;
import com.getpostapi.GetPostSpringBootApi.repository.ApiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiConfiguration {

    //@Bean
    CommandLineRunner commandLineRunner(ApiRepository apiRepository){


        return args -> {
            UserData userData = new UserData("Ashu","Singh","1234567","usernameASHU");
            UserData userDataTwo = new UserData("Ashu","Singh","1234567","vancherR");

            apiRepository.saveAll(List.of(userData,userDataTwo));


        };
    }


}
