package com.karol.trainingmanager.controllers.dev.user;

import com.karol.trainingmanager.model.entities.buisnessLogic.Training;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/v1/user/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserControllerApi {

    @PostMapping("create/account")
    ResponseEntity<Long> createAccount(@RequestParam String userName, String userPassword);

    @PostMapping("log/in")
    ResponseEntity<Long> logIn(@RequestParam String userName, String userPassword);

    @PostMapping("log/out")
    ResponseEntity<Long> logOut();

    @PostMapping("save/training")
    ResponseEntity<Long> saveTraining(@RequestBody Training training);
}
