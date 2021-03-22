package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.Permission;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
@Entity
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
