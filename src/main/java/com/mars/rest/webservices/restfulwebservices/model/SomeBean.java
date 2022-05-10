package com.mars.rest.webservices.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"field1"}) // dùng thay @JsonIgnore
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    private String field2;
//    @JsonIgnore // để aor mật  field3 và không trả về không sử dụng MappingJacksonValue
    private String field3;

}
