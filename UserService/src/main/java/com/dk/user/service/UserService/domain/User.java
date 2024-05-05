package com.dk.user.service.UserService.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "ms_user")
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name", length = 15)
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "about")
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();

    @Transient
    private List<Hotel> hotels=new ArrayList<>();



}
