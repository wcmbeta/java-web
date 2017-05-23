package com.water.spring;

import com.water.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 使用注解使用Spring
 * Created by Water on 17/5/17.
 * Email:water471871679@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {
    @Resource(name = "car")
    private Car car;
    @Test
     public void test1(){
        car.setName("玛莎拉蒂");
         System.out.println(car.toString());
     }
}
