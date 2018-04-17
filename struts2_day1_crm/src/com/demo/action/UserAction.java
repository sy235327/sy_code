package com.demo.action;

import com.demo.domain.User;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户的模块的控制器
 */
public class UserAction extends ActionSupport{

    /**
     * 处理登陆
     * @return
     */
    public String login(){
        //获取request对象
        HttpServletRequest request = ServletActionContext.getRequest();

        //获取请求参数
        Map<String, String[]> map = request.getParameterMap();

        //创建一个对象
        User user = new User();

        try {
            //封装数据
            BeanUtils.populate(user,map);

            //调用业务层
            User login = new UserService().login(user);

            //判断
            if(login == null){
                //用户名或者密码错误
                return LOGIN;
            }else{
                //存到session中
                request.getSession().setAttribute("user",login);
                return SUCCESS;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return NONE;
    }
}
