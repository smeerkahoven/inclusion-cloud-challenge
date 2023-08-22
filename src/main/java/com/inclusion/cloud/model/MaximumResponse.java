package com.inclusion.cloud.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * Clase de respuesta o salida al Json
 */
public class MaximumResponse {

    private int result;

    public MaximumResponse(final int result){
        this.result = result;
    }

}
