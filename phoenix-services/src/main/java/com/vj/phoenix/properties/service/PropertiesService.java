package com.vj.phoenix.properties.service;

import com.vj.phoenix.properties.dao.PropertiesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesService.class);

    @Autowired
    private PropertiesDao propertiesDao;

    public String get(String appName, String envName, String key){
        return get(appName, envName, key, null);
    }

    public String get(String appName, String envName, String key, String defaultValue){
        String appRowKey = appName + "." + key;
        String envRowKey = key;

        if(!propertiesDao.containsProperty(appRowKey) && !propertiesDao.containsProperty(envRowKey)){
            if(defaultValue != null){
                LOGGER.warn("The passed key: [{}] is not present in the properties store. Hence returning the default value: [{}]", key, defaultValue);
                return defaultValue;
            }
            LOGGER.warn("The passed key: [{}] is not present in the properties store. Hence returning 'null'", key);
            return null;
        }
        return propertiesDao.getPropertyValue(envName, appRowKey, envRowKey);
    }

}
