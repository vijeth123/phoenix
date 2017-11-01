package com.vj.phoenix.properties.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertiesController {

    @RequestMapping(value = "/{appName}/{envName}/{key:.+}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getPropertyValue(@PathVariable("appName") String appName, @PathVariable("envName") String envName, @PathVariable("key") String key){
        return "Application name: "+appName+"\n"+"Environment: "+envName+"\n"+"Key: "+key;
    }

}
