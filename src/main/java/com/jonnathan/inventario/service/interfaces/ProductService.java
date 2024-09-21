package com.jonnathan.inventario.service.interfaces;

import com.jonnathan.inventario.dto.ProductDTO;
import com.jonnathan.inventario.util.GeneralResponse;

public interface ProductService {
    GeneralResponse create(ProductDTO dto);
    GeneralResponse updateById(Integer id, ProductDTO dto);
    GeneralResponse getById(Integer id);
    GeneralResponse getAll();
    GeneralResponse deleteById(Integer id);
}
