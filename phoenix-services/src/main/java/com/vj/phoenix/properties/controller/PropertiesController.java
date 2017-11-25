package com.vj.phoenix.properties.controller;

import com.vj.phoenix.properties.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/property")
public class PropertiesController {
    @Autowired
    private PropertiesService propertiesService;

    @RequestMapping(value = "/{appName:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> getPropertiesMap(@PathVariable("appName") String appName){
        return propertiesService.getPropertiesMap(appName);
    }

}
