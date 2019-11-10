package pl.coderslab.spring_boot_project;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class AppConfig {

    //    przyjmowanie danych z formularza wieloczesciowego (umozliwia przesylanie danych binarnych)
//    @Bean
//    public MultipartResolver multipartResolver() {
//        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
//        return multipartResolver;
//    }



}
