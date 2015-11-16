package com.daba.beantool.util;

import com.daba.beantool.bean.BeanPropBean;
import com.daba.beantool.bean.DBPropBean;
import com.daba.beantool.bean.IbatisPropBean;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * desc:
 * author: zhangyangyang
 * date: 2015/11/12 16:00
 */
public class PropUtil {
    private static BeanPropBean beanPropBean;
    private static IbatisPropBean ibatisPropBean;
    private static DBPropBean dbPropBean;

    public static BeanPropBean getBeanPropBean() {
        if (null != beanPropBean)
            return beanPropBean;
        beanPropBean = new BeanPropBean();
        Properties properties = load("bean.properties");
        beanPropBean.setFileName(properties.getProperty("fileName"));
        beanPropBean.setFilePath(properties.getProperty("filePath"));
        beanPropBean.setPackageName(properties.getProperty("packageName"));
        properties.clear();
        return beanPropBean;
    }

    public static IbatisPropBean getIbatisPropBean() {
        if (null != ibatisPropBean)
            return ibatisPropBean;

        ibatisPropBean = new IbatisPropBean();
        Properties properties = load("ibatis.properties");
        ibatisPropBean.setOpen(Boolean.parseBoolean(properties.getProperty("open")));
        ibatisPropBean.setResultMap(Boolean.parseBoolean(properties.getProperty("resultMap")));
        ibatisPropBean.setSelectAll(Boolean.parseBoolean(properties.getProperty("selectAll")));
        properties.clear();
        return ibatisPropBean;
    }

    public static DBPropBean getDbPropBean() {
        if (null != dbPropBean)
            return dbPropBean;
        dbPropBean = new DBPropBean();
        Properties properties = load("dbconfig.properties");
        dbPropBean.setTableName(properties.getProperty("tableName"));
        dbPropBean.setDriverClass(properties.getProperty("driverClass"));
        dbPropBean.setName(properties.getProperty("name"));
        dbPropBean.setPwd(properties.getProperty("pwd"));
        dbPropBean.setUrl(properties.getProperty("url"));
        properties.clear();
        return dbPropBean;
    }

    private static Properties load(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
