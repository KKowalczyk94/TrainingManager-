package com.karol.trainingmanager.controllers.base.impl;

import com.karol.trainingmanager.controllers.base.CrudControllerApi;
import com.karol.trainingmanager.services.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class CrudController <T, K> extends  ReadableController <T, K> implements CrudControllerApi <T, K> {

    public  CrudController (CrudService <T, K> crudService){
        super(crudService);
    }

    @Override
    public ResponseEntity setDiscountinueDate(String targetClass, String idColunmName, K id) {
        return new ResponseEntity(crudService.setDiscontinueDate(targetClass, idColunmName, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity update(T entity) {
        crudService.save(entity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(T entity) {
        crudService.save(entity);
        return new ResponseEntity(HttpStatus.OK);
    }
}
