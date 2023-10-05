package com.karol.trainingmanager.controllers.base;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReadebleControllerApi <K> {

    @GetMapping("/{findall}")
    ResponseEntity findAll (@RequestParam(defaultValue = "${app.default.page.number}") @Min(0) int page,
                            @RequestParam(defaultValue = "${app.default.page.size}") @Min(1) int size,
                            @RequestParam String sortBy);

    @GetMapping("/{ids}")
    ResponseEntity findAllById(@PathVariable @NotNull @DecimalMin("0") List<K> ids);
}
