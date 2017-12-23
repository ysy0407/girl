package com.ysy.girl.service;

import com.ysy.girl.Repostory.GirlRepostroy;
import com.ysy.girl.entity.Girl;
import com.ysy.girl.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * GirlService
 *
 * @author yusongyuan
 * @create 2017-12-21 19:02
 **/
@Service
public class GirlService {

    @Autowired
    private GirlRepostroy girlRepostroy;

    //Transactional:事务管理注解，当该方法中的一条语句失败，其他的都不执行
    //一般查询不用加事务管理的注解，修改，删除，添加 都是需要添加该注解的
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl("A", 18, "A");
        girlRepostroy.save(girlA);
        Girl girlB = new Girl("BBBBBBBB", 19, "B");
        girlRepostroy.save(girlB);
    }

    public Girl getAge(Integer id) throws Exception{
        Girl girl = girlRepostroy.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //直接抛出异常
            throw new GirlException("err-9998");
        }else if(age < 18){
            throw new Exception("你还在上中学吧~");
        }else {
            return girl;
        }
    }

}
