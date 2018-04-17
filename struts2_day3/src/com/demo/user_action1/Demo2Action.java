package com.demo.user_action1;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 原生的API
 * 使用ServletActionContext方式获取request和response等等
 */
public class Demo2Action extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //获取request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for (String key : keys){
            String[] vals = map.get(key);
            System.out.println(key+"  "+ Arrays.toString(vals));
        }


        request.setAttribute("msg","AA");
        request.getSession().setAttribute("msg","BB");
        request.getServletContext().setAttribute("msg","CC");

        HttpServletResponse response = ServletActionContext.getResponse();
        //使用输出流
        response.getWriter().print("<h1>输出成功</h1>");
        return SUCCESS;
    }
}
