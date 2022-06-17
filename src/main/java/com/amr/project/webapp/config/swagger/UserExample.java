package com.amr.project.webapp.config.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**Модели помечаются аннотацией @ApiModel */
@ApiModel(value = "UserDto")
public class UserExample {

    /**Поля модели помечаются @ApiModelProperty, в параметре можно добавить
     * примечания, имя, пример, необходимость(по дефолту false) */
    @ApiModelProperty(notes = "Username of the user", name = "username", example = "qwerty",required = true)
    private String username;
    @ApiModelProperty(notes = "Password of the user", name = "password", example = "12345",required = true)
    private String password;
    @ApiModelProperty(notes = "email of the user", name = "email", example = "info@kata.academy")
    private String email;

    public UserExample(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
