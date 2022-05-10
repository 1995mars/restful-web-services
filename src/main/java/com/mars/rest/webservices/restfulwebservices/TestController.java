package com.mars.rest.webservices.restfulwebservices;

import com.mars.rest.webservices.restfulwebservices.config.Password;
import com.mars.rest.webservices.restfulwebservices.model.PersonV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private Password password;

    @GetMapping("controller")
    public PersonV1 test(){
        PersonV1 personV1 = new PersonV1("tung");
        return personV1;
    }

    @GetMapping("test-Configuration")
    public String testConfiguration(){
        return password.testBean();
    }

    @GetMapping("testNotBean")
    public String testNotBean(){
        return password.test1();
    }

}
