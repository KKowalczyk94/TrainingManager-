package com.karol.trainingmanager.controllers.base;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CrudControllerApi <T, K>{

    @DeleteMapping("/delete")
    ResponseEntity setDiscountinueDate(@RequestParam @NotNull String targetClass,
                                       @RequestParam @NotNull String idColunmName,
                                       @RequestParam @NotNull K id);

    @PutMapping("/update")
    ResponseEntity update (@RequestParam @NotNull T entity);

    @PostMapping("/create")
    ResponseEntity create (@RequestBody @NotNull T entity);
}
