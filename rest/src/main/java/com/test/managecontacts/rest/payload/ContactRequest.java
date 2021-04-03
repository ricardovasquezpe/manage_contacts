package com.test.managecontacts.rest.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.util.Date;

public class ContactRequest {

    @JsonProperty("fullName")
    @NotEmpty(message = "Please provide a name")
    @Size(max = 100)
    private String fullName;

    @JsonProperty("password")
    @NotEmpty(message = "Please provide a password")
    @Size(max = 100)
    @Size(min = 8)
    private String password;

    @JsonProperty("birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    @NotNull(message = "Please provide a birthdate")
    private Date birthDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
