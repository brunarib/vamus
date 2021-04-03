package br.com.vamus.entities;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted is false")
@Table(name = "museus")
@Entity
public class MuseuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted", insertable = false)
    protected  Boolean deleted;

    @PrePersist
    @SuppressWarnings("unused")
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    @SuppressWarnings("unused")
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Column(name = "nome")
    protected String nome;

    @Column(name = "descricao", columnDefinition="TEXT")
    protected String descricao;

    @Column(name = "endereco")
    protected String endereco;

    @Column(name = "latitude")
    protected Long latitude;

    @Column(name = "logitude")
    protected Long longitude;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    protected CategoriaEntity categoria;


}