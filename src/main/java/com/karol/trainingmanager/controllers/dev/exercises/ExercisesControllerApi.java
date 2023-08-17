package com.karol.trainingmanager.controllers.dev.exercises;

import com.karol.trainingmanager.model.entities.buisnessLogic.Exercise;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/v1/exercises/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ExercisesControllerApi {

    @PostMapping("create/exercise")
    ResponseEntity<Long> createExercise(@RequestBody Exercise exercise);
}
