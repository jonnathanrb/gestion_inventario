package com.jonnathan.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Providers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProviderEntity {
    @Id
    @Column(name = "provider_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    private String email;
}
