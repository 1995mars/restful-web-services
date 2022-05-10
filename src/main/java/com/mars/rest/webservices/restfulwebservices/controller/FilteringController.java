package com.mars.rest.webservices.restfulwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mars.rest.webservices.restfulwebservices.model.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

//    @GetMapping("/filtering")
//    public SomeBean retrieveSomeBean(){
//        FilterProvider filterProvider;
//        MappingJacksonValue mappingJacksonValue
//        return new SomeBean("field1","field2","field3");
//    }

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("field1", "field2", "field3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public List<?> retrieveSomeBeanList(){
        return Arrays.asList(new SomeBean("field1", "field2", "field3"),
                    new SomeBean("field12", "field22", "field32")
                );
    }

    @GetMapping("/filtering-list-filter")
    public MappingJacksonValue retrieveSomeBeanListFilter(){
        List<?> list = Arrays.asList(new SomeBean("field1", "field2", "field3"),
                new SomeBean("field12", "field22", "field32")
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

}
