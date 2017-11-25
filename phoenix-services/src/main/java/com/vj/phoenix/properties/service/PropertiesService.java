package com.vj.phoenix.properties.service;

import com.vj.phoenix.properties.dao.PropertiesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PropertiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesService.class);

    @Autowired
    private PropertiesDao propertiesDao;

    public Map<String, String> getPropertiesMap(String appName){
        return propertiesDao.getPropertiesMap(appName);
    }

}
