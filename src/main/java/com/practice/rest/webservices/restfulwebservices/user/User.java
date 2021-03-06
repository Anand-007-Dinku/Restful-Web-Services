package com.practice.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
/**
 * @author Anand SN
 */
@ApiModel(description = "All details about the User")
public class User extends RepresentationModel<User> {

    private Integer id;

    @ApiModelProperty(notes = "Name should have at least 2 character")
    @Size(min=2,message = "Name should have at least 2 character")
    private String name;

    @ApiModelProperty(notes = "Birth date should be in the past")
    @Past
    private Date birthDate;

    //Important : Can not construct instance of com.practice.rest.webservices.restfulwebservices.user No creators like default constructor error '
    //Important We used to get above error in the older versions of the spring boot applications
    //Important :  SPRING BOOT UPDATE - With the recent Jackson & Spring boot versions, the default constructor is no longer needed! You will not see the above mentioned error
    //Default Constructor is no longer needed
    /*protected User(){

    }*/

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
