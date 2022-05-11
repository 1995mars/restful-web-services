package com.mars.rest.webservices.restfulwebservices;

import com.mars.rest.webservices.restfulwebservices.config.FirebaseConfig;
import com.mars.rest.webservices.restfulwebservices.config.Password;
import com.mars.rest.webservices.restfulwebservices.model.Name;
import com.mars.rest.webservices.restfulwebservices.model.PersonV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private Password password;

    @Autowired
    private FirebaseConfig firebaseConfig;

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

    @RequestMapping(value = "requestMapping", method = RequestMethod.GET)
    public String requestMapping() {
        return "index";
    }

//    @GetMapping("requestMapping")
//    public String requestMapping() {
//        return "index";
//    }
    @RequestMapping(value = "requestWithParam", method = RequestMethod.GET)
    public String requestWithParam(@RequestParam(value = "name") String name){
        return name;
    }

    @RequestMapping(value = "/requestWithPathVariable/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable String name){
        return name;
    }

    @RequestMapping(value = "/requestWithmultiPathVariable/name/{name}/email/{email}", method = RequestMethod.GET)
    public String requestWithmultiPathVariable(@PathVariable String name,@PathVariable String email){
        return name + '-' + email;
    }

    @GetMapping("requestBody")
    public Name requestBody(@RequestBody Name name) {
        return name;
    }

    @GetMapping("testException")
    public Name testException(@RequestBody Name name) {
        int a = 0;
        int b = 10/a;
        return name;
    }

//    firebaseConfig
    @GetMapping("testConfig")
    public String testConfig(@RequestBody Name name) {
        System.out.println(firebaseConfig);
        return firebaseConfig.getEmail();
    }
}
