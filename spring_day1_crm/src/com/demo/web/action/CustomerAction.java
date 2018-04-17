package com.demo.web.action;

import com.demo.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * 客户的action
 */
public class CustomerAction extends ActionSupport {
    /**
     * 保存客户
     * @return
     */
    public String save(){
        System.out.println("WEB层:保存客户");

        /*//使用spring工厂,由框架加载配置实例化对象,我们获取对象调用方法
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService service = (CustomerService) ac.getBean("CustomerService");
        service.save();*/

        //需要获取一个ServletContext对象传递给WEB整合包工厂(让spring工厂加载配置实例化在服务器运行的时候运行,只会运行一次,节省资源)
        ServletContext servletContext = ServletActionContext.getServletContext();
        //使用WEB整合包的工厂方式,将配置加载后的实例化的对象存储到ServletContext对象中
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //和spring工厂类获取对象一样的方式
        CustomerService service = (CustomerService) context.getBean("CustomerService");
        service.save();

        return NONE;
    }
}
