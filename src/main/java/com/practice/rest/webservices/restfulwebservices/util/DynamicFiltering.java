package com.practice.rest.webservices.restfulwebservices.util;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

/**
 * @author Anand SN
 */

@Service
public class DynamicFiltering {

    public MappingJacksonValue dynamicFilterFilterOutAllExcept(Object someBean, String nameOfFilter, String... propertyArray){

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(nameOfFilter, filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filterProvider);

        return mapping;
    }

}
