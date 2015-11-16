package com.daba.beantool;

import com.daba.beantool.bean.BeanPropBean;
import com.daba.beantool.bean.DBPropBean;
import com.daba.beantool.bean.IbatisPropBean;
import com.daba.beantool.bean.SqlMapBean;
import com.daba.beantool.util.BeanUtil;
import com.daba.beantool.util.FileUtil;
import com.daba.beantool.util.IbatisUtil;
import com.daba.beantool.util.PropUtil;

/**
 * desc:
 * author: zhangyangyang
 * date: 2015/11/12 19:10
 */
public class Main {
    public static void main(String[] args) throws Exception {
        genBeanFile();
        genIbatisFile();
    }

    private static void genBeanFile() throws Exception {
        System.out.println("开始生成javabean");
        String ret = BeanUtil.createBean();
        BeanPropBean beanPropBean = PropUtil.getBeanPropBean();
        String path = beanPropBean.getFilePath();
        String fileName = beanPropBean.getFileName() + ".java";
        FileUtil.saveFile(path, fileName, ret);
        System.out.println("生成javabean文件成功");
        System.out.println("生成的文件路径: " + path);
        System.out.println("生成的文件: " + fileName);
    }

    private static void genIbatisFile() throws Exception{
        IbatisPropBean ibatisPropBean = PropUtil.getIbatisPropBean();
        if (ibatisPropBean.isOpen()) {
            SqlMapBean mapBean = IbatisUtil.genSqlMapBean();
            System.out.println("开始生成ibatis文件");
            DBPropBean dbPropBean = PropUtil.getDbPropBean();
            String ret = mapBean.genSqlMapStr();
            String fileName = dbPropBean.getTableName() + ".sql.xml";
            String filePath = PropUtil.getBeanPropBean().getFilePath();
            FileUtil.saveFile(filePath, fileName, ret);
            System.out.println("生成ibatis文件:" + fileName);
            System.out.println("生成的文件路径: " + filePath);

        }
    }
}
