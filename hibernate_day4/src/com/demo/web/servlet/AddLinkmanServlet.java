package com.demo.web.servlet;

import com.demo.domain.Linkman;
import com.demo.service.LinkmanService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 添加联系人
 */
@WebServlet(name = "AddLinkmanServlet",urlPatterns = "/addLinkman")
public class AddLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.乱码
        request.setCharacterEncoding("utf-8");

        //2.接收数据
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map.get("cust_id")[0]);

        //3.先获取客户的id,返回一个数组但是只有一个值
        String scust_id = map.get("cust_id")[0];

        //转换,将客户id转为String类型
        Long cust_id = Long.parseLong(scust_id);

        //可以封装数据
        Linkman man = new Linkman();
        try {
            BeanUtils.populate(man,map);

            //调用业务层,保存联系人
            new LinkmanService().save(man,cust_id);
            System.out.println("保存联系人成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
