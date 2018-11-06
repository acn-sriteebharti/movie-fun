package org.superbiz.moviefun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean pintoBean(ActionServlet servlet){
        ServletRegistrationBean output = new ServletRegistrationBean();
        output.addUrlMappings("/moviefun/*");
        output.setServlet(servlet);
        return output;
    }
}