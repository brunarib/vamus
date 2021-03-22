package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tematicas")
@Entity
public class TematicaEntity extends BaseEntity{

    @Column(name = "nome")
    private String nome;
}
