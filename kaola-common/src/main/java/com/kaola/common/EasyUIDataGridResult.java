package com.kaola.common;

import java.io.Serializable;
import java.util.List;

/**
 * Author:Zhoumc
 * Description: EasyUI返回
 * DATA:11:29 2017/10/26
 */
public class EasyUIDataGridResult  implements Serializable{

    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
