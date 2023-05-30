package com.karol.trainingmanager.service.impl;

import com.karol.trainingmanager.model.entities.TestEntity;
import com.karol.trainingmanager.model.repository.TestRepositoryApi;
import com.karol.trainingmanager.service.interfaces.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepositoryApi testRepository;

    @Override
    public Long upload(String name) {
        return testRepository.save(TestEntity.builder().name(name).build()).getId();
    }

    @Override
    public List<TestEntity> getAll() {
        return testRepository.findAll();
    }

    @Override
    public TestEntity getById(Long id) {
        return testRepository.findById(id).orElse(null);
    }
}
