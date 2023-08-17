package com.karol.trainingmanager.model.repository.test;

import com.karol.trainingmanager.model.entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepositoryApi extends JpaRepository<TestEntity, Long> {
}
