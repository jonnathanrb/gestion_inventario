package com.jonnathan.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Float price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id")
    private ProviderEntity provider;

    @ManyToMany
    @JoinTable(
            name = "Product_Categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryEntity> categories = new HashSet<>();
}
