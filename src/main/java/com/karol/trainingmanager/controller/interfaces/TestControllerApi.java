package com.karol.trainingmanager.controller.interfaces;

import com.karol.trainingmanager.model.entities.TestEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/test", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TestControllerApi {

    @PostMapping("/upload")
    ResponseEntity<Long> upload(@RequestParam("name") String name);

    @GetMapping("/get/all")
    ResponseEntity<List<TestEntity>> getAll();

    @GetMapping("get/byid")
    ResponseEntity<TestEntity> getById(Long id);
}
