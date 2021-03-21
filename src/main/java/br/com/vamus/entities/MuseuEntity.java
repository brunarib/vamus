package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "museus")
@Entity
public class MuseuEntity extends BaseEntity {

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "descricao", nullable = false,columnDefinition="TEXT")
    protected String descricao;

    @Column(name = "endereco", nullable = false)
    protected String endereco;

    @Column(name = "latitude", nullable = false)
    protected Long latitude;

    @Column(name = "logitude", nullable = false)
    protected Long longitude;

    @Column(name = "created_at", nullable = false)
    protected Categoria categoria;

    @Column(name = "created_at", nullable = false)
    protected List<EventoEntity> eventoEntities;
}
