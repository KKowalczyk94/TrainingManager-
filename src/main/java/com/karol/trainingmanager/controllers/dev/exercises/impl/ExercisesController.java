package com.karol.trainingmanager.controllers.dev.exercises.impl;

import com.karol.trainingmanager.controllers.base.impl.CrudController;
import com.karol.trainingmanager.controllers.dev.exercises.ExercisesControllerApi;
import com.karol.trainingmanager.model.entities.buisnessLogic.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExercisesController<T, K> extends CrudController<T, K> implements ExercisesControllerApi{


//    @Override
//    public ResponseEntity<Long> createExercise(Exercise exercise) {
//        return null;
//    }
}
