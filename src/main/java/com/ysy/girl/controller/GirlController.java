package com.ysy.girl.controller;

import com.ysy.girl.Repostory.GirlRepostroy;
import com.ysy.girl.entity.Result;
import com.ysy.girl.service.GirlService;
import com.ysy.girl.entity.Girl;
import com.ysy.girl.utils.ResultUtil;
import com.ysy.girl.ymlenum.PathEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Girl控制类
 *
 * @author yusongyuan
 * @create 2017-12-21 18:08
 **/
@RestController
public class GirlController {

    Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepostroy girlRepostroy;
    @Autowired
    private GirlService girlService;
    @Autowired
    private Environment env; //获取配置文件信息
    @Autowired
    private ResultUtil resultUtil;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/getGirls")
    public List<Girl> girlList(){
        return girlRepostroy.findAll();
    }

    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping("/findByAge")
    public List<Girl> findByAge(@RequestParam("age") Integer age){
        return girlRepostroy.findByAge(age);
    }

    /**
     * 添加一个女生
     * @param name
     * @param age
     * @param cupSize
     * @return 返回类型为Girl 会自动转为json对象
     */
    @PostMapping("/addGirl01")
    public Girl addGirl01(@RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl(name, age, cupSize);
        return girlRepostroy.save(girl); //save返回的就是添加的对象

    }

    //用这样的方式直接将传入的信息转为Girl实体类
    @PostMapping("/addGirl02")
    public Result<Girl> addGirl02(@Valid Girl girl, BindingResult bindingResult){
        //如果验证获取到错误，输出错误信息
        if(bindingResult.hasErrors()){
            String errCode = bindingResult.getFieldError().getDefaultMessage();
            Result result = resultUtil.error(PathEnum.RESULT.getPath(),errCode);
            logger.error(result.toString());
            return result;
        }
         return resultUtil.success(girlRepostroy.save(girl)) ;
    }

    //查询一个女生 如果该id是不存在的，状态码：200，返回的是null
    @GetMapping("/getGirl")
    public Girl getGirl(@RequestParam("id") Integer id){
        return girlRepostroy.findOne(id);
    }

    //删除一个女生
    @DeleteMapping("/delGirl")
    public void delGirl(@RequestParam("id") Integer id){
        girlRepostroy.delete(id);
    }

    //更新一个女生
    //使用put方式，前端应当使用：body：x-www-form-urlencoded 将表单内的数据转换为键值对
    @PutMapping("/putGirl")
    public Girl updateGirl(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl(name, age, cupSize);
        girl.setId(id);
        return girlRepostroy.save(girl); //当save有主键的时候，为更新
    }

    @GetMapping("/addGirls")
    public void addGirls(){
        girlService.insertTwo();
    }

    @GetMapping("/getAge/{id}")
    public Result getAge(@PathVariable("id") Integer id) throws Exception{
        return resultUtil.success(girlService.getAge(id));
    }

}
