package org.drewandjen.config;

import org.drewandjen.dao.ListDao;
import org.drewandjen.dao.MasterListDao;
import org.drewandjen.dao.MasterListDaoH2;
import org.drewandjen.dao.MemoryListDao;
import org.drewandjen.web.ListController;
import org.drewandjen.web.MasterListController;
import org.drewandjen.web.SimpleCorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * Created by dhite on 8/24/15.
 */
@Configuration
@EnableAutoConfiguration
public class WebRunner {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory(){
        TomcatEmbeddedServletContainerFactory server = new TomcatEmbeddedServletContainerFactory("/jenlist", 8092);
        return server;
    }

    @Bean
    public FilterRegistrationBean corsFilter(){
        SimpleCorsFilter filter = new SimpleCorsFilter();
        FilterRegistrationBean result = new FilterRegistrationBean();
        result.setFilter(filter);
        result.setName("cors");
        result.setUrlPatterns(Collections.singletonList("/*"));
        return result;
    }

    @Bean
    public ListDao dao(){
        return new MemoryListDao();
    }

    @Bean
    public MasterListDao masterListDao(){
        return new MasterListDaoH2(new JdbcTemplate(dataSource()));
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
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql").addScript("classpath:data.sql").build();
    }

    @Bean
    public ListController listController(){
        return new ListController(dao());
    }

    @Bean
    public MasterListController masterListController(){
        return new MasterListController(masterListDao());
    }

    public static void main(String[] args) {
        SpringApplication.run(WebRunner.class, args);
    }
}
