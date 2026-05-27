package com.demo.restfulservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToITemsAndEmptyName_thenCorrectResponse() throws Exception {
        String itemWithoutName = "{\"name\":\"\", \"description\":\"Una descripción válida\"}";

        mockMvc.perform(post("/api/items")
                .contentType("application/json")
                .content(itemWithoutName))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPostRequestToItemsAndNullDescription_thenCorrectResponse() throws Exception {
        String itemWithoutDescription =  "{\"name\":\"Item de prueba\"}";

        mockMvc.perform(post("/api/items")
                .content(itemWithoutDescription)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}