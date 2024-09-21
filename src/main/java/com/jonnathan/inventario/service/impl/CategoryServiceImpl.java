package com.jonnathan.inventario.service.impl;

import com.jonnathan.inventario.dto.CategoryDTO;
import com.jonnathan.inventario.entity.CategoryEntity;
import com.jonnathan.inventario.repository.CategoryRepository;
import com.jonnathan.inventario.service.interfaces.CategoryService;
import com.jonnathan.inventario.util.GeneralResponse;
import com.jonnathan.inventario.util.Utilities;
import com.jonnathan.inventario.util.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final Utilities utilities;
    private final CategoryMapper mapper;

    @Override
    public GeneralResponse create(CategoryDTO dto) {
        try {
            CategoryEntity entity = mapper.toEntity(dto);

            repository.save(entity);

            return this.utilities.successResponse("Saved successfully", null);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse updateById(Integer id, CategoryDTO dto) {
        try {
            // Find Category
            Optional<CategoryEntity> element = repository.findById(id);

            // Check if category exists
            if (element.isEmpty()){
                return this.utilities.notFoundResponse("Element with id " + id + " not found");
            }

            // Convert dto to Entity
            CategoryEntity category = mapper.toEntity(dto);

            // Update and get the element updated
            CategoryEntity categoryUpdated = repository.save(category);

            // Convert the element updated and return it
            CategoryDTO categoryUpdatedDTO = mapper.toDTO(categoryUpdated);

            return this.utilities.successResponse("Category updated successfully", categoryUpdatedDTO);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse getById(Integer id) {
        try {
            // Check if category with given id exists
            Optional<CategoryEntity> element = repository.findById(id);

            if (element.isEmpty()){
                // Category not exists
                return this.utilities.notFoundResponse("Category with id " + id + " not found");
            }

            // Get category and convert to DTO
            CategoryEntity category = element.get();
            CategoryDTO dto = mapper.toDTO(category);

            return this.utilities.successResponse("Success", dto);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse getAll() {
        try {
            // Get all categories
            List<CategoryEntity> categories = repository.findAll();

            if (categories.isEmpty()){
                // No categories were found
                return this.utilities.notFoundResponse("Categories not found");
            }

            // Convert to a list of CategoryDTOs
            List<CategoryDTO> dtos = mapper.toDTOList(categories);

            return this.utilities.successResponse(dtos.size() + " elements found", dtos);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse deleteById(Integer id) {
        try {
            // Find the category
            Optional<CategoryEntity> category = repository.findById(id);

            // Check if category exists
            if (category.isEmpty()){
                // Category not found
                return this.utilities.notFoundResponse("Category with id " + id + " not found");
            }

            // Category found: delete it
            repository.deleteById(id);

            return this.utilities.successResponse("Category deleted successfully", null);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }
}
