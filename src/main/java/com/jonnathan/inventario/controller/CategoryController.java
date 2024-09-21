package com.jonnathan.inventario.controller;

import com.jonnathan.inventario.dto.CategoryDTO;
import com.jonnathan.inventario.service.interfaces.CategoryService;
import com.jonnathan.inventario.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getCategoryById(@PathVariable Integer id) {
        GeneralResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<GeneralResponse> getAllCategories() {
        GeneralResponse response = service.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> createCategory(@RequestBody CategoryDTO dto) {
        GeneralResponse response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO dto) {
        GeneralResponse response = service.updateById(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
