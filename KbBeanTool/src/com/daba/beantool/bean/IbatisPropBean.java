package com.daba.beantool.bean;

/**
 * desc:
 * author: zhangyangyang
 * date: 2015/11/12 16:04
 */
public class IbatisPropBean {
    private boolean open;
    private boolean resultMap;
    private boolean selectAll;

    public IbatisPropBean() {
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isResultMap() {
        return resultMap;
    }

    public void setResultMap(boolean resultMap) {
        this.resultMap = resultMap;
    }

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }
}
