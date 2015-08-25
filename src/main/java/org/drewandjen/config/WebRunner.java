package org.drewandjen.config;

import org.drewandjen.dao.ListDao;
import org.drewandjen.dao.MemoryListDao;
import org.drewandjen.web.ListController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by dhite on 8/24/15.
 */
@Configuration
@EnableWebMvc
public class WebRunner {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory(){
        TomcatEmbeddedServletContainerFactory server = new TomcatEmbeddedServletContainerFactory("/jenlist", 8092);
        return server;
    }

    @Bean
    public ListDao dao(){
        return new MemoryListDao();
    }

    @Bean(name = "defaultDispatch")
    public ServletRegistrationBean dispatcherRegistration() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebRunner.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet, "/*");
        registration.setLoadOnStartup(1);
        registration.setName("dispatch");
        return registration;
    }

    @Bean
    public ListController listController(){
        return new ListController(dao());
    }

    public static void main(String[] args) {
        SpringApplication.run(WebRunner.class, args);
    }
}
