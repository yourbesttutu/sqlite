package com.pxp.SQLite.demo.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringRegistrationBeanServlet {
  @Bean
  public ServletRegistrationBean<LoginServlet> genericCustomServlet() {
    ServletRegistrationBean<LoginServlet> bean = new ServletRegistrationBean<>(new LoginServlet(), "/api/v1/login");
    bean.setLoadOnStartup(1);
    return bean;
  }
}
