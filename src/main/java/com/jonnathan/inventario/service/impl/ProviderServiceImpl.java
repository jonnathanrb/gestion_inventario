package com.jonnathan.inventario.service.impl;

import com.jonnathan.inventario.dto.CategoryDTO;
import com.jonnathan.inventario.dto.ProviderDTO;
import com.jonnathan.inventario.entity.CategoryEntity;
import com.jonnathan.inventario.entity.ProviderEntity;
import com.jonnathan.inventario.repository.CategoryRepository;
import com.jonnathan.inventario.repository.ProviderRepository;
import com.jonnathan.inventario.service.interfaces.ProviderService;
import com.jonnathan.inventario.util.GeneralResponse;
import com.jonnathan.inventario.util.Utilities;
import com.jonnathan.inventario.util.mapper.CategoryMapper;
import com.jonnathan.inventario.util.mapper.ProviderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository repository;
    private final Utilities utilities;
    private final ProviderMapper mapper;

    @Override
    public GeneralResponse create(ProviderDTO dto) {
        try {
            ProviderEntity entity = mapper.toEntity(dto);

            repository.save(entity);

            return this.utilities.successResponse("Saved successfully", null);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse updateById(Integer id, ProviderDTO dto) {
        try {
            // Find Provider
            Optional<ProviderEntity> element = repository.findById(id);

            // Check if provider exists
            if (element.isEmpty()){
                return this.utilities.notFoundResponse("Element with id " + id + " not found");
            }

            // Convert dto to Entity
            ProviderEntity category = mapper.toEntity(dto);

            // Update and get the element updated
            ProviderEntity providerUpdated = repository.save(category);

            // Convert the element updated and return it
            ProviderDTO providerUpdatedDTO = mapper.toDTO(providerUpdated);

            return this.utilities.successResponse("Provider updated successfully", providerUpdatedDTO);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse getById(Integer id) {
        try {
            // Check if provider with given id exists
            Optional<ProviderEntity> element = repository.findById(id);

            if (element.isEmpty()){
                // Provider not exists
                return this.utilities.notFoundResponse("Provider with id " + id + " not found");
            }

            // Get provider and convert to DTO
            ProviderEntity provider = element.get();
            ProviderDTO dto = mapper.toDTO(provider);

            return this.utilities.successResponse("Success", dto);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse getAll() {
        try {
            // Get all providers
            List<ProviderEntity> providers = repository.findAll();

            if (providers.isEmpty()){
                // No providers were found
                return this.utilities.notFoundResponse("Providers not found");
            }

            // Convert to a list of ProviderDTOs
            List<ProviderDTO> dtos = mapper.toDTOList(providers);

            return this.utilities.successResponse(dtos.size() + " elements found", dtos);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }

    @Override
    public GeneralResponse deleteById(Integer id) {
        try {
            // Find the provider
            Optional<ProviderEntity> provider = repository.findById(id);

            // Check if provider exists
            if (provider.isEmpty()){
                // Provider not found
                return this.utilities.notFoundResponse("Provider with id " + id + " not found");
            }

            // Provider found: delete it
            repository.deleteById(id);

            return this.utilities.successResponse("Provider deleted successfully", null);
        } catch (Exception e){
            return this.utilities.exceptionResponse(e.getMessage(), e);
        }
    }
}
