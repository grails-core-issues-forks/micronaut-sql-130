package example.micronaut.entities;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Nonnull
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Nonnull
    private String name;

    /**
     * Constructor.
     */
    public BookEntity() {
    }

    @Nonnull
    public Long getId() {
        return id;
    }

    public void setId(@Nonnull Long id) {
        this.id = id;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }
}