package com.shakil.qrcodescanning.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "ticket_validity",
        "name",
        "email",
        "phone",
        "date_of_birth",
        "profile_picture"
})
public class Profile implements Serializable {

    @JsonProperty("ticket_validity")
    private String ticket_validity;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("date_of_birth")
    private String date_of_birth;
    @JsonProperty("profile_picture")
    private String profile_picture;

    public Profile() {
    }

    @JsonProperty("ticket_validity")
    public String getTicket_validity() {
        return ticket_validity;
    }

    @JsonProperty("ticket_validity")
    public void setTicket_validity(String ticket_validity) {
        this.ticket_validity = ticket_validity;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("date_of_birth")
    public String getdate_of_birth() {
        return date_of_birth;
    }

    @JsonProperty("date_of_birth")
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @JsonProperty("profile_picture")
    public String getProfile_picture() {
        return profile_picture;
    }

    @JsonProperty("profile_picture")
    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}