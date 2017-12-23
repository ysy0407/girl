package com.ysy.girl.service;

import com.ysy.girl.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * girl Service 单元测试
 *
 * @author yusongyuan
 * @create 2017-12-23 16:28
 **/
@RunWith(SpringRunner.class) //底层使用的是junit4
@SpringBootTest //表示启动整个springboot的工程
public class GirlServiceTest {
    @Test
    public void insertTwo() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

    @Autowired
    private GirlService girlService;

    @Test
    public void getAgeTest() throws Exception{
        Girl girl = girlService.getAge(new Integer(16));
        Girl girl1 = new Girl("哦-洛天依", new Integer(14), "A");
        Assert.assertEquals(new Integer(19), girl.getAge());
    }

}
