package com.user.application.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Data
@NoArgsConstructor
@Entity
public class Userr {
    @Id
    @JsonProperty("USER-ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    @JsonProperty("USERNAME")
    private String username;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("MOBILE")
    private String mobile;
    @JsonProperty("DEPT-ID")
    private int deptid;
}
