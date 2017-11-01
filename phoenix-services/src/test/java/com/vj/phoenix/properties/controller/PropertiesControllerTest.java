package com.vj.phoenix.properties.controller;

import com.vj.phoenix.properties.service.PropertiesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class PropertiesControllerTest {

    @InjectMocks
    private PropertiesController propertiesController;

    @Mock
    private PropertiesService propertiesService;

    private MockMvc mockMvc;

    private String key;
    private String defaultValue;
    private String value;
    private String appName;
    private String envName;

    @Before
    public void setUp() throws Exception{
        appName = "data-ingestion";
        envName = "dev";
        key = "test.key";
        defaultValue = "test-default-value";
        value = "test-value";
        mockMvc = MockMvcBuilders.standaloneSetup(propertiesController).build();
    }

    @Test
    public void getPropertyValue() throws Exception {
        Mockito.when(propertiesService.get(appName, envName, key)).thenReturn(value);
        mockMvc.perform(get("/property/" + appName + "/" + envName + "/" + key))
                .andExpect(status().isOk())
                .andExpect(content().string(value));
    }

    @Test
    public void getPropertyValue1() throws Exception {
        Mockito.when(propertiesService.get(appName, envName, key, defaultValue)).thenReturn(value);
        mockMvc.perform(get("/property/" + appName + "/" + envName + "/" + key + "/" + defaultValue))
                .andExpect(status().isOk())
                .andExpect(content().string(value));
    }

}