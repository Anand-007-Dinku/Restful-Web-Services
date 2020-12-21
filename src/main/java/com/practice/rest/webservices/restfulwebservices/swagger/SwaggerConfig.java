package com.practice.rest.webservices.restfulwebservices.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

/**
 * @author Anand SN
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact("Anand","","anamastemath@gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title","Awesome API Description"
            ,"1.0","urn:tos",DEFAULT_CONTACT, "Apache 2.0","http://www.apache.org/licence/LICENCE-2.0");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("Application/json", "application/xml"));

    //Important : Below are the two URIs which produces API documentations
    // http://localhost:8081/v2/api-docs
    // http://localhost:8081/swagger-ui.html


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }


    //Important: Combination of HATEOAS and SWAGGER results in this error : Parameter 0 of method linkDiscoverers in org.springframework.hateoas.config.HateoasConfiguration
    //Important: therefore use below code snippet discovers();
    //Important: https://stackoverflow.com/questions/58431876/why-hateoas-starts-creating-issue-for-spring-boot-version-2-2-x-during-startu
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }



}
