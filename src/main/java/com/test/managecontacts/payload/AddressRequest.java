package com.test.managecontacts.payload;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddressRequest {
    @NotBlank
    @Size(max = 45)
    private String city;

    @NotBlank
    @Size(max = 45)
    private String postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
