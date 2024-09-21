package com.jonnathan.inventario.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProviderDTO {
    private Integer id;
    private String name;
    private String telephoneNumber;
    private String email;
}
