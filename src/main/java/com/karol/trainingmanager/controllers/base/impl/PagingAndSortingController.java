package com.karol.trainingmanager.controllers.base.impl;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class PagingAndSortingController{
   // @Override
    public Map<String, Object> prepareResponseMap(Page page) {
                Map<String, Object> response = new HashMap<>();
        response.put("data", page.getContent());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        return response;
    }
}
