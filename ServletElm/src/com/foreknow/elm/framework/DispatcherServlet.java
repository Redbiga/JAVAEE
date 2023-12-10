package com.foreknow.elm.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 *     自定义的前端控制器，主要是拦截url，格式的要求：/控制器类名/控制器方法名
 *     流程：
 *     1.中文编码的处理
 *     2.获取客户端请求的路径(/Controller类名/Controller方法)：请求的url与Controller方法映射：http://localhost:8080/elm/Controller类名/Controller方法
 *     3.根据获取到的请求路径来获取到Controller类名以及Controller的方法名
 *     4.调用Controller中的方法
 *     5.最后将获取到的数据以json的格式返回给客户端
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.中文编码的处理
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      //设置服务器端向客户端返回的内容类型为json
      response.setContentType("application/json;charset=utf-8");
      //2.获取客户端请求的路径  	String getServletPath() 获取请求的 URL 的一部分。
      String path = request.getServletPath();

      //3.根据获取到的请求路径来获取到Controller类名以及Controller的方法名
      //例如：path="/Controller类名/Controller方法"
      String className =  path.substring(1,path.lastIndexOf("/"));
      String methodName = path.substring(path.lastIndexOf("/")+1);
      PrintWriter out= response.getWriter();
      try {
        //4.通过Java中的反射机制调用Controller中的方法（了解就可以，后期在Spring的时候会详细描述）
        //通过Class.forName来获取Controller类中的信息
        Class clazz = Class.forName("com.foreknow.elm.controller."+className);
        //创建Controller对象
        Object controller = clazz.newInstance();
        //获取Controller中的方法
        //public void A(HttpServletRequest req)
        Method method = clazz.getMethod(methodName,new Class[]{HttpServletRequest.class});
        //调用Contoller中的方法
        Object result = method.invoke(controller,new Object[]{request});

        //5.最后将获取到的数据以json的格式返回给客户端
        //jackson中提供的对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //将调用方法返回的数据以json的格式返回给前端
        out.print(objectMapper.writeValueAsString(result));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
