package com.karol.trainingmanager.controllers.dev.training;

import com.karol.trainingmanager.model.entities.buisnessLogic.Training;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/v1/training/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TrainingControllerApi {

    @PostMapping("create/training")
    ResponseEntity<Long> createTraining(@RequestBody Training training);
}
