package com.mars.rest.webservices.restfulwebservices.controller;

import com.mars.rest.webservices.restfulwebservices.model.Name;
import com.mars.rest.webservices.restfulwebservices.model.PersonV1;
import com.mars.rest.webservices.restfulwebservices.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Tung");
    }
    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("tran","tung"));
    }

    @GetMapping( value = "/person/params", params = "version=1")
    public PersonV1 param1(){
        return new PersonV1("Tung");
    }
//    http://localhost:8081/person/params?version=2
    @GetMapping( value = "/person/params", params = "version=2")
    public PersonV2 param2(){
        return new PersonV2(new Name("tran","tung"));
    }

    @GetMapping( value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 header1(){
        return new PersonV1("Tung");
    }

    @GetMapping( value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 header2(){
        return new PersonV2(new Name("tran","tung"));
    }
}
