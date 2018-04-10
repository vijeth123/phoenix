package com.vj.phoenix.properties.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vj.phoenix.properties.service.PropertiesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PropertiesControllerTest {

    @InjectMocks
    private PropertiesController propertiesController;

    @Mock
    private PropertiesService propertiesService;

    private MockMvc mockMvc;

    private Map<String, String> map = new HashMap<>();
    private String appName;

    @Before
    public void setUp() throws Exception{
        appName = "data-ingestion";
        map.put("k1", "v1");
        mockMvc = MockMvcBuilders.standaloneSetup(propertiesController).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void getPropertyValue() throws Exception {
        Mockito.when(propertiesService.getPropertiesMap(appName)).thenReturn(map);

        String result = new ObjectMapper().writeValueAsString(map);

        mockMvc.perform(get("/property/" + appName))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

}