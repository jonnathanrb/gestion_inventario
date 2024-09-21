package com.jonnathan.inventario.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;
}
