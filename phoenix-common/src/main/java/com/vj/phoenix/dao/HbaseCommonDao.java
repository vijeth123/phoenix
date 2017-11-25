package com.vj.phoenix.dao;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HbaseCommonDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(HbaseCommonDao.class);

    private static Connection connection;

    public HbaseCommonDao() throws IOException {
        connection = ConnectionFactory.createConnection(HBaseConfiguration.create());
    }

    public String getColumnValue(String nameSpace, String tableName, String rowKey, String columnFamily, String column){
        try(Table hbaseTable = connection.getTable(TableName.valueOf(nameSpace, tableName))) {
            Get get = new Get(Bytes.toBytes(rowKey));
            if(hbaseTable.exists(get)){
                Result result = hbaseTable.get(get);
                return Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes(column)));
            }
        } catch (IOException e) {
            LOGGER.error("Failed to get the column value for table: [{}], column-family: [{}], row-key: [{}], column: [{}]. Exception is: {}", tableName, columnFamily, rowKey, column, e);
        }
        return null;
    }

}
