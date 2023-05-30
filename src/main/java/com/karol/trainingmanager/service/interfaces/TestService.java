package com.karol.trainingmanager.service.interfaces;

import com.karol.trainingmanager.model.entities.TestEntity;

import java.util.List;

public interface TestService {

    Long upload(String name);

    List <TestEntity> getAll ();

    TestEntity getById (Long id);
}
