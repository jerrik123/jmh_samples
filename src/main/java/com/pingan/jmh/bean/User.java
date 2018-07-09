package com.pingan.jmh.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Copyright 2018/7/9 lcfarm All Rights Reserved
 * 请添加类/接口的说明：
 *
 * @Package: com.pingan.jmh.bean
 * @author: Jerrik
 * @date: 2018/7/9 21:59
 */
public class User implements Serializable {
    private Integer id;

    private String userName;

    private Integer age;

    private String address;

    public User() {
    }

    public User(Integer id, String userName, Integer age, String address) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
