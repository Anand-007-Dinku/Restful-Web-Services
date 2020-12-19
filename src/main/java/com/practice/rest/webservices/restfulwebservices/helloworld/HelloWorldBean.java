package com.practice.rest.webservices.restfulwebservices.helloworld;

/**
 * @author Anand SN
 */
public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}

//IMPORTANT: If we dont create a getter-setter, then the automatic conversion will not work.
//IMPORTANT: ERROR: No converter found for return value of type: class com.practice.rest.webservices.restfulwebservices.model.HelloWorldBean