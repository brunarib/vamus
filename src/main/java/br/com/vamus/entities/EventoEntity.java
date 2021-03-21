package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="eventoEntities")
@Entity
public class EventoEntity extends BaseEntity {

    @Column(name="museu_id")
    private MuseuEntity museuEntity;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tematica")
    private Tematica tematica;

    @Column(name = "tag")
    private Tag tag;

    @Column(name = "ini_evento")
    private LocalDateTime IniEvento;

    @Column(name = "fim_evento")
    private LocalDateTime FimEvento;

    @Column(name = "gratuito")
    private Boolean gratuito =true;

    @Column(name = "valor")
    private Float valor;

}
