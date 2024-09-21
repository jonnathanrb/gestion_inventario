package com.jonnathan.inventario.service.interfaces;

import com.jonnathan.inventario.dto.ProviderDTO;
import com.jonnathan.inventario.util.GeneralResponse;

public interface ProviderService {
    GeneralResponse create(ProviderDTO dto);
    GeneralResponse updateById(Integer id, ProviderDTO dto);
    GeneralResponse getById(Integer id);
    GeneralResponse getAll();
    GeneralResponse deleteById(Integer id);
}
