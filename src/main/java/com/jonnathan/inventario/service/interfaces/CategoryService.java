package com.jonnathan.inventario.service.interfaces;

import com.jonnathan.inventario.dto.CategoryDTO;
import com.jonnathan.inventario.util.GeneralResponse;

public interface CategoryService {
    GeneralResponse create(CategoryDTO dto);
    GeneralResponse updateById(Integer id, CategoryDTO dto);
    GeneralResponse getById(Integer id);
    GeneralResponse getAll();
    GeneralResponse deleteById(Integer id);
}
