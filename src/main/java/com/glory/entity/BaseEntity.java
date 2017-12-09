package com.glory.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by Monster on 2017/12/5.
 */
public class BaseEntity implements Serializable {

    private static final  long serialVersionUID = -1679678105511847175L;

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
