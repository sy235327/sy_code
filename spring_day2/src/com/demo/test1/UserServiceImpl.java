package com.demo.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 通过注解配置spring
 * 组件注解,标记类
 * value
 * <bean id="userService" class="com.demo.test1.UserServiceImpl" ></bean> == @Component(value="userService")
 *
 * 标记类有四种注解
 * @Component(value="类似bean标签的id属性")
 * @Respository(value="类似bean标签的id属性")
 * @Service(value="类似bean标签的id属性")
 * @
 */

//标记类作用和bean一样,value的作用和id作用一样
@Component(value="userService")
//@Scope(value="prototype") value取值 singleton单例和prototype多例
public class UserServiceImpl implements UserService {

    //给name属性注入一个字符串(和基本类型),setName方法可以省略不写
    @Value(value="大桥未久")
    private String name;

    // 单@Autowired 按类型自动装配,在容器中找到此接口默认将实现类注入进来(一般都是使用id注入进来)

    //@Autowired @Qualifier(value="ud") 按名称注入 需要id值(就是在类上面配置的Component注解的value值)注入方式
    //@Autowired
    //@Qualifier(value="ud")

    //@Resource 是java的注解,Spring框架支持该注解 作用和@Autowired @Qualifier(value="ud")一样 按name属性的值(名称)去容器中找
    @Resource(name="ud")
    private UserDao userDao;

    /*public void setName(String name) {
        this.name = name;
    }*/

    @Override
    public void sayHell() {
        System.out.println("hello spring  "+name);
        userDao.save();
    }

    //@PostConstruct 作用和init-method这个属性一样 对象实例化时调用的方法
    @PostConstruct
    public void init(){
        System.out.println("初始化成功");
    }

    //@PreDestroy 作用和destroy-method这个属性一样 对象销毁时调用的方法
    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }
}
