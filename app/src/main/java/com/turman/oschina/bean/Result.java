package com.turman.oschina.bean;

import java.io.Serializable;

/**
 * Created by dqf on 2016/4/20.
 */
@SuppressWarnings("serial")
public class Result implements Serializable {
    public int errorCode;
    public String errorMessage;

    public boolean OK() {
        return errorCode == 1;
    }
}
