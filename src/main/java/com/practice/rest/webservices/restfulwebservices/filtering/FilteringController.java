package com.practice.rest.webservices.restfulwebservices.filtering;

import com.practice.rest.webservices.restfulwebservices.util.DynamicFiltering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Anand SN
 */

@RestController
public class FilteringController {

    @Autowired
    DynamicFiltering filtering;

    //Dynamic filtering
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        String nameOfFilter = "SomeBeanFilter";
        String[] propertyArrayExcept = {"field1"};

        MappingJacksonValue mapping = filtering.dynamicFilterFilterOutAllExcept(someBean,nameOfFilter,propertyArrayExcept);

        return mapping;
    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListSomeBean(){

        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value21", "value22", "value23"));

        String nameOfFilter = "SomeBeanFilter";
        String[] propertyArrayExcept = {"field1"};

        MappingJacksonValue mapping = filtering.dynamicFilterFilterOutAllExcept(list,nameOfFilter,propertyArrayExcept);

        return mapping;
    }
}
