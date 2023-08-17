package com.karol.trainingmanager.controllers.dev.training.impl;

import com.karol.trainingmanager.controllers.dev.training.TrainingControllerApi;
import com.karol.trainingmanager.model.entities.buisnessLogic.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrainingController implements TrainingControllerApi {
    @Override
    public ResponseEntity<Long> createTraining(Training training) {
        return null;
    }
}
