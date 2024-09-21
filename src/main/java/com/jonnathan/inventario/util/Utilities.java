package com.jonnathan.inventario.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class Utilities {
    public GeneralResponse successResponse(String comments, Object data){
        return GeneralResponse.builder()
                .code("200")
                .message("Success")
                .data(data)
                .comments(comments)
                .build();
    }

    public GeneralResponse notFoundResponse(String comments){
        return GeneralResponse.builder()
                .code("404")
                .message("NotFound")
                .comments(comments)
                .build();
    }

    public GeneralResponse errorResponse(String comments){
        return GeneralResponse.builder()
                .code("400")
                .message("BadRequest")
                .comments(comments)
                .build();
    }

    public GeneralResponse exceptionResponse(String comments, Exception e){
        return GeneralResponse.builder()
                .code("500")
                .message("Internal Server Error")
                .comments(comments)
                .data(e)
                .build();
    }
}
