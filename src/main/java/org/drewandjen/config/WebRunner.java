package org.drewandjen.config;

import org.drewandjen.dao.*;
import org.drewandjen.model.UserInfoCache;
import org.drewandjen.web.CategoryController;
import org.drewandjen.web.MasterListController;
import org.drewandjen.web.ShoppingListController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;

/**
 * Created by dhite on 8/24/15.
 */
@Configuration
@EnableAutoConfiguration
@Import(SecurityConfig.class)
public class WebRunner {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        TomcatEmbeddedServletContainerFactory server = new TomcatEmbeddedServletContainerFactory("/jenlist", 8092);
        return server;
    }

    @Bean
    public CategoryDao categoryDao(){
        return new CategoryDaoH2(getTemplate());
    }

    @Bean
    public ShoppingListDao shoppingListDao() {
        return new ShoppingListDaoH2(getTemplate());
    }

    @Bean
    public MasterListDao masterListDao() {
        return new MasterListDaoH2(getTemplate());
    }

    @Bean
    public JdbcTemplate getTemplate() {
        return new JdbcTemplate(dataSource());
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
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql").addScript("classpath:data.sql").build();
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoH2(getTemplate());
    }

    @Bean
    public UserInfoCache userInfoCache(){
        return new UserInfoCache(userDao());
    }

    @Bean
    public ShoppingListController listController() {
        return new ShoppingListController(shoppingListDao(), userInfoCache());
    }

    @Bean
    public MasterListController masterListController() {
        return new MasterListController(masterListDao(), userInfoCache());
    }

    @Bean
    public CategoryController categoryController(){
        return new CategoryController(categoryDao());
    }

    public static void main(String[] args) {
        SpringApplication.run(WebRunner.class, args);
    }
}
