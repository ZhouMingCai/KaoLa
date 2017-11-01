package com.kaola.common;

import java.io.Serializable;

/**
 * Author:Zhoumc
 * Description:EasyUITree
 * DATA:14:36 2017/10/26
 */
public class EasyUITreeNode  implements Serializable{

    private  long id;
    private  String text;
    private  String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
