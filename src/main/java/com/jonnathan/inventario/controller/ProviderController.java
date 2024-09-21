package com.jonnathan.inventario.controller;

import com.jonnathan.inventario.dto.ProviderDTO;
import com.jonnathan.inventario.service.interfaces.ProviderService;
import com.jonnathan.inventario.util.GeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/provider")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService service;

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getProviderById(@PathVariable Integer id) {
        GeneralResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<GeneralResponse> getAllProviders() {
        GeneralResponse response = service.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> createProvider(@RequestBody ProviderDTO dto) {
        GeneralResponse response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateProvider(@PathVariable Integer id, @RequestBody ProviderDTO dto) {
        GeneralResponse response = service.updateById(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
