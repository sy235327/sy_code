package com.demo.action1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 每个新的请求就会创建一个新的action就会单独创建一个ValueStack对象(值栈),将值栈放入request域对象中
 *
 * 值栈就相当于Struts2框架的数据的中转站，向值栈存入一些数据。从值栈中获取到数据。
 * ValueStack 是 struts2 提供一个接口，实现类 OgnlValueStack ---- 值栈对象 （OGNL是从值栈中获取数据的 ）
 * Action是多例的，有一起请求，创建Action实例，创建一个ActionContext对象，代表的是Action的上下文对象，还会创建一个ValueStack对象。
 * 每个Action实例都有一个ValueStack对象 （一个请求 对应 一个ValueStack对象 ）
 * 在其中保存当前Action 对象和其他相关对象
 * Struts 框架把 ValueStack 对象保存在名为 “struts.valueStack” 的请求属性中,request中 （值栈对象 是 request一个属性）
 * 获取值栈 ValueStack vs = (ValueStack)request.getAttribute("struts.valueStack");
 */
public class ValueStackAction extends ActionSupport {
    //框架在调用action前会创建一个StrutsActionProxy对象,对其初始化把action对象放入值栈中
//    private User user = new User("王五","456");
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    /**
     * 演示值栈对象的目录结构
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
       /* //使用获取值栈对象
        //获取request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        //获取值栈
        ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
        System.out.println(vs);*/

       //获取到值栈对象,先获取到ActionContext对象
        ValueStack vs = ActionContext.getContext().getValueStack();
        System.out.println(vs);

        //向值栈中的root栈压入值 从栈顶压入栈顶后续的数据向后移动
        vs.push("老王");

        //判断栈顶值是否为map集合,如果是则将数据存储到map集合中,如果不是创建一个map将数据放入map集合中,压入栈顶,后续的数据向后移动
        vs.set("msg","大桥未久");

        //栈顶已经有了map集合,直接将值放入map集合中
        vs.set("info","苍老师");
        return SUCCESS;
    }

    /**
     * 演示从值栈中取值
     * @return
     */
    public String save(){
        //从ActionContext上下文对象中获取到值栈
        ValueStack vs = ActionContext.getContext().getValueStack();
        //压栈
//        vs.push("大桥未久");
//        vs.set("msg","苍老师");

        //创建User对象
//        User user =  new User("大桥未久","123");
        //压栈
//        vs.push(user);
        //set压栈
//        vs.set("user",user);

        List<User> userList = new ArrayList<User>();
        userList.add(new User("王一","1"));
        userList.add(new User("王二","2"));
        userList.add(new User("王3","3"));

        //将集合压入栈中
//        vs.push(userList);
        //set方法压栈
        vs.set("userList",userList);

        //从context栈中获取值,底层已经封装了request session application attr parameters对象,操作就是map集合
//        HttpServletRequest request = ServletActionContext.getRequest();
        //自动将request封装到context栈中
//        request.setAttribute("msg","波多野结衣");
//        ActionContext.getContext().getSession().put("msg","张三");
        return SUCCESS;
    }


}
