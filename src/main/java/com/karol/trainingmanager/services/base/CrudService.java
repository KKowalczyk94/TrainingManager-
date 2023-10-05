package com.karol.trainingmanager.services.base;

import com.karol.trainingmanager.model.repository.base.CustomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class CrudService <T, K> {

    protected  JpaRepository <T, K> crudRepository;

    private  CustomRepository customRepository;

    public CrudService(JpaRepository jpaRepository) {
        this.crudRepository = jpaRepository;
    }

    public Page<T> findAll(Pageable peageable) {
        return crudRepository.findAll(peageable);
    }

    public Page<T> findall (Pageable pageable){
        return crudRepository.findAll(pageable);
    }

    public List<T> findallById (Iterable<K> ids) {
        return crudRepository.findAllById(ids);
    }

    public Optional<T> findAllById(K id){
        return crudRepository.findById(id);
    }

    public void save (T entity){
        crudRepository.saveAndFlush(entity);
    }

    public K setDiscontinueDate(String targetClass, String idColumnName, K id) {
        return (K) customRepository.setDiscontinueDate(targetClass, idColumnName, id);
    }}
