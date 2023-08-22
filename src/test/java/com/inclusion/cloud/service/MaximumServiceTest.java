package com.inclusion.cloud.service;

import com.inclusion.cloud.model.MaximumModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MaximumServiceTest {

    @InjectMocks
    private MaximumService service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testValues(){
        final MaximumModel model = new MaximumModel(7,5,12345);
        final int result =service.findMaximumSolution(model);

        Assertions.assertEquals(12339, result);
    }

    @Test
    void testArrayValues(){
        final MaximumModel model1 = new MaximumModel(7,5,12345);
        final MaximumModel model2 = new MaximumModel(5,0,4);
        final MaximumModel model3 = new MaximumModel(10,5,15);

        final List<Integer> result =service.findMaximum(List.of(model1, model2, model3));

        Assertions.assertEquals(List.of(12339,0,15),result);
    }

}
