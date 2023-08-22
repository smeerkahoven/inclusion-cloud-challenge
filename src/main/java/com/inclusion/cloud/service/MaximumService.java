package com.inclusion.cloud.service;

import com.inclusion.cloud.model.MaximumModel;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio Principal donde ejecuta la llamada principal y resuelve el problema del
 * Code Challenge
 */
@Service
@Validated
public class MaximumService {

    /**
     *
     * @param maximumModels Lista de modelos (x,y,n)
     * @return
     *  una lista de enteros para cada una de las listas de entrada
     */
    public List<Integer> findMaximum(final List<MaximumModel> maximumModels){
        return  maximumModels.stream()
                .map(value->findMaximumSolution(value))
                .collect(Collectors.toList());
    }

    public int findMaximumSolution(final MaximumModel model){
        return findMaximumSolution(model.getX(), model.getY(), model.getN());
    }

    /**
     *  Metodo principal del code challenge donde se realiza el calculo del numero k
     * @param x
     * @param y
     * @param n
     * @return
     */
    private int findMaximumSolution(final int x, final int y, final int n){
        int result = -1;

        for(int k = 0; k <= n; k++) {
            if (k % x == y) {
                result = Math.max(result, k);
            }
        }
        return ((result >= 0 && result <= n) ? result : -1);
    }
}
