package com.turman.oschina.bean;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by dqf on 2016/4/20.
 */
@SuppressWarnings("serial")
@Root(name = "result")
@Default(value = DefaultType.FIELD,required = false)
public class Result implements Serializable {
    public int errorCode;
    public String errorMessage;

    public boolean OK() {
        return errorCode == 1;
    }
}
