package com.daba.beantool.bean;

import java.util.Set;

import static com.daba.beantool.util.StrUtil.LB;
import static com.daba.beantool.util.StrUtil.getBlank;

/**
 * desc:
 * author: zhangyangyang
 * date: 2015/11/13 11:33
 */
public class ResultMap {
    private String id;
    private String clazz;
    private Set<IbatisResult> resultSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Set<IbatisResult> getResultSet() {
        return resultSet;
    }

    public void setResultSet(Set<IbatisResult> resultSet) {
        this.resultSet = resultSet;
    }

    public String genResultMap() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlank(4) + "<resultMap id=\"" + id + "\" class=\"" + clazz + "\">" + LB);
        for (IbatisResult result : resultSet) {
            sb.append(getBlank(8) + "<result property=\"" + result.getProperty() + "\" " +
                    "column=\"" + result.getColumn() + "\" />" + LB);
        }
        sb.append(getBlank(4) + "</resultMap>" + LB);
        return sb.toString();
    }
}
