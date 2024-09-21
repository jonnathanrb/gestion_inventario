package com.jonnathan.inventario.dto;

import com.jonnathan.inventario.entity.CategoryEntity;
import com.jonnathan.inventario.entity.ProviderEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
    private ProviderEntity provider;
    private Set<CategoryEntity> categories = new HashSet<>();
}
