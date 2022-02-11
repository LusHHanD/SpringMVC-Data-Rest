package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
@Entity
@Table(name="userRegister")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userID")
    private Long userID;

    @Column(name="userName")
    private String userName;

    @Column(name="userMail")
    private String userMail;

    @Column(name="userPassword")
    private String userPassword;
}
