/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.elinar.react.rest.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Mika Mähönen
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    private final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);
    @Bean
    public Docket api() { 

        springfox.documentation.service.Contact cont = new springfox.documentation.service.Contact("Mika Mähönen","http://www.elinar.fi","mika.mahonen@elinar.fi");
        List<VendorExtension> extensions= new ArrayList<>();
        ApiInfo apiInfo = new ApiInfo("Rest Template","Rest Template","1.0","",cont,"","",extensions);
        
        
        Docket doc = new  Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .apiInfo(apiInfo)
          .select()
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.regex("/api/.*"))                          
          .build(); 
        
        
        Set<String> protocols = new HashSet<>();
        protocols.add("HTTP");
        protocols.add("HTTPS");        
        doc.protocols(protocols);
        
        return doc;
        
        
    }
    


 
}