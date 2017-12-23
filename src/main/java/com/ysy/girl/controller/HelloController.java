package com.ysy.girl.controller;

import com.ysy.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Hello World
 *
 * @author yusongyuan
 * @create 2017-12-21 9:47
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${cupSize}") //获取配置文件中的属性
    private String cupSize;
//    @Value("${age}") //自动转换类型
    private int age;
//    @Value("${content}") //输出形式 cupSize: A, age: 18
    private String content;
//如果java文件中调用配置文件中的属性，必须输入全名：girl.age，启动报错

    @Autowired //自动注入
    private GirlProperties girlProperties;

    //使用多个路径都可访问，应该还支持通配符
    @RequestMapping(value = {"/yeah", "/hi"}, method = RequestMethod.GET)
    public String say(){
        return "Hello World !!!"+cupSize+age+content;
    }

    @RequestMapping(value = "/girlSay", method = RequestMethod.GET)
    public String girlSay(){
        return girlProperties.getCupSize()+girlProperties.getAge();
    }

    //@PathVariable 获取url中的值  getID/21321  id即为21321
    @RequestMapping(value = "/getID/{id}", method = RequestMethod.GET)
    public String getID(@PathVariable("id") int id){
        return "id:"+id;
    }

    //@RequestParam 获取url中参数的值 getName?name=ddd name 即为 ddd
    //  required:是否为必传 默认为true
    //  defaultValue:默认值 格式需要为String
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName(@RequestParam(value = "name", required = false, defaultValue = "ysy") String name){
        return "name:"+name;
    }

    //GetMapping 必须使用
    //  对应的有PostMapping 必须使用post方法请求
    @GetMapping("/getAge")
    public String getAge(@RequestParam(value = "age", required = false, defaultValue = "18") int age){
        return "age:"+age;
    }

}
