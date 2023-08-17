package com.karol.trainingmanager.controllers.test.impl;

import com.karol.trainingmanager.controllers.test.TestControllerApi;
import com.karol.trainingmanager.model.entities.TestEntity;
import com.karol.trainingmanager.services.test.impl.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController implements TestControllerApi {

    private final TestServiceImpl testService;

    @Override
    public ResponseEntity<Long> upload(String name) {
        return ResponseEntity.ok(testService.upload(name));
    }

    @Override
    public ResponseEntity<List<TestEntity>> getAll() {
        return ResponseEntity.ok(testService.getAll());
    }

    @Override
    public ResponseEntity<TestEntity> getById(Long id) {
        return ResponseEntity.ok(testService.getById(id));
    }
}
