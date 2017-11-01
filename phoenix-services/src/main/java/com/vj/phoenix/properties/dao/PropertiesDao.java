package com.vj.phoenix.properties.dao;

public interface PropertiesDao {
    String getPropertyValue(String envName, String appId, String propertyName);
    boolean containsProperty(String propertyName);
}
