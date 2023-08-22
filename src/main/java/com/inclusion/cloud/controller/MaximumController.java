package com.inclusion.cloud.controller;

import com.inclusion.cloud.model.MaximumModel;
import com.inclusion.cloud.model.MaximumResponse;
import com.inclusion.cloud.service.MaximumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controllador Principal
 *
 */
@RestController
@RequestMapping("/challenge")
public class MaximumController {

    private final MaximumService maximumService;

    @Autowired
    public MaximumController(final MaximumService maximumService){
        this.maximumService = maximumService;
    }

    /**
     * Metodo post para maximum.
     *
     * @param model deben agregarse los valores para x, y , n
     * @return
     *
     * retorna el maixmo entero k que 0<= k <= n
     */
    @PostMapping("/maximum")
    public ResponseEntity<?> maximumPost(@Valid @RequestBody final MaximumModel model){
        return new ResponseEntity<>(new MaximumResponse(maximumService.findMaximumSolution(model)), HttpStatus.OK) ;
    }

    /**
     *
     * @param x Valor x para el maximo
     * @param y Valor y para el maximo
     * @param n Valor n para el maximo
     * @return
     *  retorna el maixmo entero k que 0<= k <= n
     */
    @GetMapping("/maximum")
    public ResponseEntity<MaximumResponse> maximumGet(@RequestParam(name = "x", required = true) final int x,
                                                      @RequestParam(name="y", required = true) final int y,
                                                      @RequestParam(name = "n", required = true) final int n){
        return new ResponseEntity<>(new MaximumResponse(maximumService.findMaximumSolution(new MaximumModel(x,y,n))), HttpStatus.OK) ;
    }
}
