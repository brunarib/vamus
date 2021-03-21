package br.com.vamus.entities;

import javax.persistence.Column;
import java.security.Permission;

public class UserEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "permission_id")
    private Permission permission;

}
