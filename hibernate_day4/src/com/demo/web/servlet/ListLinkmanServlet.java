package com.demo.web.servlet;

import com.demo.domain.Linkman;
import com.demo.service.LinkmanService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListLinkmanServlet",urlPatterns = "/listLinkman")
public class ListLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求的参数
        request.setCharacterEncoding("utf-8");
        String lkmName = request.getParameter("lkmName");

        //创建一个离线条件查询的对象,脱离Session对象,先拼写sql语句,只需要传递离线条件查询的对象即可
        DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
        //添加条件
        if (lkmName != null && !lkmName.trim().isEmpty()){
            //添加条件
            criteria.add(Restrictions.like("lkm_name","%"+lkmName+"%"));
        }
        //调用业务层传递离线查询对象
        List<Linkman> mans = new LinkmanService().findAll(criteria);
        request.setAttribute("mans",mans);
        request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request,response);
    }
}
