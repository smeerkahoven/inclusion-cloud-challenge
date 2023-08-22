package com.inclusion.cloud.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
/**
 * Modelo principal para permitir los valores x, y , n
 */
public class MaximumModel {
    @NotNull(message = "Valor invalido: x is NULL")
    @Min(value = 1, message = "'x' valor debe ser mayor igual a 1")
    private int x;
    @NotNull(message = "Valor invalido: y is NULL")
    @Min(value = 0, message = "'y' valor debe ser mayor a  0")
    private int y;
    @NotNull(message = "Valor invalido: n is NULL")
    @Min(value = 1, message = "'n' valor debe ser mayor igual a 1")
    private int n;

    public MaximumModel(){

    }

    public MaximumModel(@Valid final int x, @Valid final int y,@Valid final int n){
        this.x = x ;
        this.y = y;
        this.n = n;
    }

}
