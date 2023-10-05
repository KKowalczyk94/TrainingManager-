package com.karol.trainingmanager.controllers.base.impl;

import com.karol.trainingmanager.controllers.base.ReadebleControllerApi;
import com.karol.trainingmanager.services.base.CrudService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ReadableController <T, K> extends PagingAndSortingController implements ReadebleControllerApi {

    CrudService<T, K> crudService;

    @Override
    public ResponseEntity findAll(int page, int size, String sortBy) {
        try {
            Page<T> pageTuts = crudService.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
            return !pageTuts.getContent().isEmpty() ? new ResponseEntity<>(prepareResponseMap(pageTuts), HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public ResponseEntity findAllById(List ids) {
//        return null;
//    }

    @Override
    public ResponseEntity findAllById(List ids) {
        return new ResponseEntity(crudService.findAllById((K) ids), HttpStatus.OK); //TODO casting may not work!
    }
}
