package com.vj.phoenix.properties.dao;

import java.util.Map;

public interface PropertiesDao {
    Map<String, String> getPropertiesMap(String appName);
}
