package com.ysy.girl.Repostory;

import com.ysy.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository<实体类， ID类型>
 */
public interface GirlRepostroy extends JpaRepository<Girl, Integer> {

    /**
     * 方法名称 按照 findBy{属性名称} 的格式书写，hibernate会自动创建sql语句进行查找 后面的参数应和实体类中的属性类型相同
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);

}
