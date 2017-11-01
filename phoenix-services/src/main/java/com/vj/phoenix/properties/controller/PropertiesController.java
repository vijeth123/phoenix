package com.vj.phoenix.properties.controller;

import com.vj.phoenix.properties.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

    @RequestMapping(value = "/{appName}/{envName}/{key:.+}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getPropertyValue(@PathVariable("appName") String appName, @PathVariable("envName") String envName, @PathVariable("key") String key){
        return propertiesService.get(appName, envName, key);
    }

    @RequestMapping(value = "/{appName}/{envName}/{key:.+}/{defaultValue}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getPropertyValue(@PathVariable("appName") String appName, @PathVariable("envName") String envName, @PathVariable("key") String key, @PathVariable("defaultValue") String defaultValue){
        return propertiesService.get(appName, envName, key, defaultValue);
    }

}
