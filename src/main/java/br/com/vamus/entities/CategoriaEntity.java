package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted =false")
@Table(name ="categorias")
@Entity
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted")
    protected  Boolean deleted;

    @PrePersist
    @SuppressWarnings("unused")
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
        deleted =false;
    }

    @PreUpdate
    @SuppressWarnings("unused")
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Column(name = "nome")
    private String nome;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "imagem_id", nullable = true)
    protected ImagensEntity imagemId;
}
