package com.jonnathan.inventario.util.mapper;

import com.jonnathan.inventario.dto.CategoryDTO;
import com.jonnathan.inventario.dto.ProviderDTO;
import com.jonnathan.inventario.entity.CategoryEntity;
import com.jonnathan.inventario.entity.ProviderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    ProviderEntity toEntity (ProviderDTO dto);

    ProviderDTO toDTO (ProviderEntity entity);

    // Lists
    List<ProviderEntity> toEntityList (List<ProviderDTO> dto);
    List<ProviderDTO> toDTOList (List<ProviderEntity> entity);
}
