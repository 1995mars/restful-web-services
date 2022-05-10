package com.mars.rest.webservices.restfulwebservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class User {

    private Integer id;

    @Size(min=2, message = "Phải có ít nhất 2 kí tự")
    private String name;
    @Past
    private Date birthDate;
}
