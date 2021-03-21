package br.com.vamus.entities;

import javax.persistence.Column;

public class TagEntity extends BaseEntity{

    @Column(name = "nome")
    private String nome;

}
