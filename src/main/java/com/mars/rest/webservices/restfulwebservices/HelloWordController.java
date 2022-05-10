package com.mars.rest.webservices.restfulwebservices;

import com.mars.rest.webservices.restfulwebservices.model.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("test")
public class HelloWordController {

    @Autowired
    private MessageSource messageSource;

    @PostMapping(value = "/hello")
    public String helloWord(){
        return "tung";
    }

    @GetMapping(value = "/helloBean")
    public HelloBean helloBean(){
        return new HelloBean("HelloBean");
    }

//    http://localhost:8081/test/helloBeanPath/tun
    @GetMapping(path = "/helloBeanPath/{name}")
    public String helloBeanPath(@PathVariable String name){
        return name;
    }

    @GetMapping(value = "/hello-world-internationalized")
    public String helloWorldInternational(
//            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ){
//        return messageSource.getMessage("good.morning.message",null,"Defaut",locale);
        return messageSource.getMessage("good.morning.message",
                null,"Defaut", LocaleContextHolder.getLocale());
    }

}
