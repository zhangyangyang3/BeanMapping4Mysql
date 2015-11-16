package com.daba.beantool.util;

import com.daba.beantool.BeanModel;
import com.daba.beantool.bean.BeanPropBean;
import com.daba.beantool.bean.ColumnBean;
import com.daba.beantool.bean.IbatisPropBean;
import com.daba.beantool.bean.IbatisResult;
import com.daba.beantool.bean.ResultMap;
import com.daba.beantool.bean.SelectSql;
import com.daba.beantool.bean.SqlMapBean;

import java.util.HashSet;
import java.util.Set;

/**
 * desc:
 * author: zhangyangyang
 * date: 2015/11/13 11:25
 */
public class IbatisUtil {

    public static SqlMapBean genSqlMapBean() throws Exception {
        BeanModel model = BeanUtil.genBeanModel();
        IbatisPropBean propBean = PropUtil.getIbatisPropBean();
        SqlMapBean sqlMapBean = new SqlMapBean();
        sqlMapBean.setNameSpace(model.getTableName());
        if (propBean.isResultMap()) {
            ResultMap resultMap = genResultMap(model.getPackageName(), model.getClassName(),
                    model.getColumnBeans());
            sqlMapBean.setResultMap(resultMap);
        }

        if (propBean.isSelectAll()) {
            SelectSql selectSql = genSelectSql(model.getTableName(), model.getPackageName(),
                    model.getClassName(), model.getColumnBeans());
            sqlMapBean.setSql(selectSql);
        }

        return sqlMapBean;
    }

    private static SelectSql genSelectSql(String tableName, String packageName, String className,
            Set<ColumnBean> columnBeans) {
        String fullClazzName = packageName + "." + className;
        SelectSql selectSql = new SelectSql(columnBeans, tableName, fullClazzName);
        return selectSql;
    }

    private static ResultMap genResultMap(String packageName, String className,
            Set<ColumnBean> columnBeans) {
        ResultMap resultMap = new ResultMap();
        resultMap.setId("rM" + className);
        resultMap.setClazz(packageName + "." + className);
        Set<IbatisResult> resultSet = genIbatisResult(columnBeans);
        resultMap.setResultSet(resultSet);
        return resultMap;
    }

    private static Set<IbatisResult> genIbatisResult(Set<ColumnBean> columnBeans) {
        Set<IbatisResult> ibatisResults = new HashSet<>();
        for (ColumnBean bean : columnBeans) {
            ibatisResults.add(new IbatisResult(bean.getBeanName(), bean.getDbName()));
        }
        return ibatisResults;
    }

}
