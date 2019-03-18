package com.x.ic.smc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.x.base.exception.SystemException;

public final class HbaseClient {
    private final static Logger LOGGER = LogManager.getLogger(HbaseClient.class);

    public static final String FIELD_SPLIT = new String(new char[] { (char) 1 });

    private static Connection connection;

    private static Properties prop = new Properties();

    private static Configuration conf;

    private static HbaseClient hbaseClient = new HbaseClient();

    private HbaseClient() {

    }

    static {
        loadResource();
    }

    public static HbaseClient getInstance() {
        return hbaseClient;
    }

    public Connection getConnection() {
        return connection;
    }

    private synchronized static void loadResource() {
        InputStream is = HbaseClient.class.getClassLoader().getResourceAsStream(
        		"paas/paas-conf.properties");
        try {
            prop.load(is);
        } catch (IOException e1) {
            throw new SystemException(e1);
        }

        conf = HBaseConfiguration.create();
        String hbaseSite = (String) prop.get("hbase.param");
        if (StringUtils.isBlank(hbaseSite)) {
            throw new SystemException("没有配置hbase.site属性信息!");
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(hbaseSite);
        for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            conf.set(entry.getKey(), entry.getValue().getAsString());
        }
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            throw new SystemException(e);
        }
    }

    /*
     * 创建表
     * 
     * @tableName 表名
     * 
     * @family 列族列表
     */
    public void creatTable(String tableName, String[] family) {
        try {
            HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();

            HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(tableName));
            for (int i = 0; i < family.length; i++) {
                desc.addFamily(new HColumnDescriptor(family[i]));
            }

            if (!admin.tableExists(tableName)) {
                admin.createTable(desc);
                LOGGER.info("create HBase table " + tableName + " success!");
            } else {
                LOGGER.info("HBase table " + tableName + " already exist");
            }
        } catch (IOException e) {
            throw new SystemException(e);
        }
    }

    boolean tableExists(String tableName) {
        boolean tableExists = false;
        try {
            tableExists = connection.getAdmin().tableExists(TableName.valueOf(tableName));
        } catch (IOException e) {
            throw new SystemException(e);
        }
        return tableExists;

    }

    /*
     * 删除表
     * 
     * @tableName 表名
     */
    public void deleteTable(String tableName) {
        try {
            HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        } catch (IOException e) {
            throw new SystemException(e);
        }
        LOGGER.info("HBase table " + tableName + "is deleted!");
    }

}
