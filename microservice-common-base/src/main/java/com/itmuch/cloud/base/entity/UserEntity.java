package com.itmuch.cloud.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="userentity")
public class UserEntity extends BaseEntity {

    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
