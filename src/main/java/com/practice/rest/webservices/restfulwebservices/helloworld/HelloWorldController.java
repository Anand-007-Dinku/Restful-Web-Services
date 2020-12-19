package com.practice.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anand SN
 */
//Controller
@RestController
public class HelloWorldController {


    //IMPORTANT: GET
    //IMPORTANT: URI - /hello-world
    //IMPORTANT: method - "Hello-world"


    //IMPORTANT: @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    //IMPORTANT: @GetMapping(value = "/hello-world")

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}