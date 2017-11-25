package com.vj.phoenix.properties.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vj.phoenix.dao.HbaseCommonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Repository
public class PropertiesDaoImpl implements PropertiesDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesDaoImpl.class);

    private Map<String, String> propertiesMap;

    @Autowired
    private HbaseCommonDao hbaseCommonDao;

    @Value("${phoenix.properties.namespace}")
    private String nameSpace;

    @Value("${phoenix.properties.table}")
    private String table;

    @Value("${phoenix.properties.column.family}")
    private String columnFamily;

    @Value("${phoenix.properties.column}")
    private String column;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<String, String> getPropertiesMap(String appName){
        String json = hbaseCommonDao.getColumnValue(nameSpace, table, appName, columnFamily, column);

        try {
            propertiesMap = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
        } catch (IOException e) {
            LOGGER.error("Exception occurred while converting the stored json back to String: {}", e);
            return null;
        }
        return Collections.unmodifiableMap(propertiesMap);
    }

}
