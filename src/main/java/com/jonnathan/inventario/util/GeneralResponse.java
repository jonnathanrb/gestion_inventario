package com.jonnathan.inventario.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class GeneralResponse {
    private String code;
    private String message;
    private Object data;
    private String comments;
}
