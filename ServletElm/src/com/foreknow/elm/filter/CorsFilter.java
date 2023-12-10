package com.foreknow.elm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      //HttpServletResponse接口对象
      //方法:void setHeader(String name, String value) 设置一个带有给定的名称和值的响应报头。
      HttpServletResponse response = (HttpServletResponse)resp;
      //注意：这里设置只允许http://locahost:8081进行跨域访问
      //http://locahost:8081:它表示的是前端的服务地址

      response.setHeader("Access-Control-Allow-Origin","http://localhost:8081");
      response.setHeader("Access-Control-Allow-Credentail","true");
      response.setHeader("Access-Control-Allow-Methods","GET, PUT, DELETE, POST");
      response.setHeader("Access-Control-Max-Age","3628800");
      response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization");
      chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
