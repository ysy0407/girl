package com.ysy.girl.entity;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Girl实体类
 *
 * @author yusongyuan
 * @create 2017-12-21 17:43
 **/
@Entity
public class Girl {

    @Id //表示该属性为主键
    @GeneratedValue //表示主键自增
    private Integer id;
    private String name;
    //验证age最低为18，否则返回的错误信息为message 使用的时候，需要在实体类前添加 @Valid
    @Max(value = 120, message = "err-1004")
    @Min(value = 18, message = "err-1003")
    @NotNull(message = "err-1002")
    private Integer age;
    @Size(min = 1, max = 1, message = "err-1001")
    private String cupSize;

    //一定要有一个无参的构造
    public Girl() {
    }

    public Girl(String name, Integer age, String cupSize) {
        this.name = name;
        this.age = age;
        this.cupSize = cupSize;
    }

    @Override
    public String
    toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
