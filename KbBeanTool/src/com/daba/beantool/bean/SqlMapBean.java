package com.daba.beantool.bean;

import static com.daba.beantool.util.StrUtil.LB;
/**
 * desc:
 * author: zhangyangyang
 * date: 2015/11/13 11:30
 */
public class SqlMapBean {
    private static final String IBATIS_HEADER = "<!DOCTYPE sqlMap PUBLIC \"-//ibatis.apache" +
            ".org//DTD SQL" +
            " Map 2.0//EN\" \"http://ibatis.apache.org/dtd/sql-map-2.dtd\">\n";
    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    private String nameSpace;
    private ResultMap resultMap;
    private SelectSql sql;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public ResultMap getResultMap() {
        return resultMap;
    }

    public void setResultMap(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    public SelectSql getSql() {
        return sql;
    }

    public void setSql(SelectSql sql) {
        this.sql = sql;
    }

    public String genSqlMapStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(XML_HEADER);
        sb.append(IBATIS_HEADER);
        sb.append("<sqlMap namespace=\""+nameSpace+"\">");
        sb.append(LB);
        sb.append(LB);

        if (null != resultMap) {
            sb.append(resultMap.genResultMap());
        }
        sb.append(LB);
        if (null != sql) {
            sb.append(sql.genSelectSql());
        }
        sb.append(LB);
        sb.append("</sqlMap>" + LB );

        return sb.toString();
    }
}
