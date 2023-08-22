package com.inclusion.cloud.controller;

import com.inclusion.cloud.service.MaximumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(MaximumController.class)
@ContextConfiguration(classes = MaximumController.class)
@Import(MaximumService.class)
public class MaximumControllerTest {

    private MockMvc mockMvc;

    private MaximumService maximumService;

    @BeforeEach
    void setup() {
        maximumService = Mockito.mock(MaximumService.class);
        final MaximumController maximumController = new MaximumController(maximumService);

        mockMvc = MockMvcBuilders.standaloneSetup(maximumController).build();
    }

    @Test
    void testGetMaximum() throws Exception {
        final String result = "{\"result\":15}";
        final String body = "{\"x\":10,\"y\":5,\"n\":15}";

        when(maximumService.findMaximumSolution(any())).thenReturn(15);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/challenge/maximum")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(result)
                );

        verify(maximumService, times(1)).findMaximumSolution(any());
    }
}
