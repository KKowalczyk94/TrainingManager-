package com.karol.trainingmanager.controllers.dev.user.impl;

import com.karol.trainingmanager.controllers.dev.user.UserControllerApi;
import com.karol.trainingmanager.model.entities.buisnessLogic.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserControllerApi {
    @Override
    public ResponseEntity<Long> createAccount(String userName, String userPassword) {
        return null;
    }

    @Override
    public ResponseEntity<Long> logIn(String userName, String userPassword) {
        return null;
    }

    @Override
    public ResponseEntity<Long> logOut() {
        return null;
    }

    @Override
    public ResponseEntity<Long> saveTraining(Training training) {
        return null;
    }
}
