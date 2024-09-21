package com.jonnathan.inventario.util.mapper;

import com.jonnathan.inventario.dto.CategoryDTO;
import com.jonnathan.inventario.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity toEntity (CategoryDTO dto);

    CategoryDTO toDTO (CategoryEntity entity);

    // Lists
    List<CategoryEntity> toEntityList (List<CategoryDTO> dto);
    List<CategoryDTO> toDTOList (List<CategoryEntity> entity);
}
