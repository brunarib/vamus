package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tematicas")
@Entity
public class TematicaEntity {

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
    private String nome;
}
