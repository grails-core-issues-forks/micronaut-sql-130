package example.micronaut;

import example.micronaut.entities.BookEntity;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Singleton
public class DefaultBookRepository implements BookRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    /**
     * Instantiates a RequestFingerPrintRepositoryImpl.
     *
     * @param entityManager The entity manager
     */
    public DefaultBookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Long save(@Nonnull @NotBlank String name) {
        BookEntity entity = new BookEntity();
        entity.setName(name);
        entityManager.persist(entity);
        return entity.getId();
    }

    @Transactional(readOnly = true)
    @Nonnull
    @Override
    public Number count() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cr = builder.createQuery(Long.class);
        Root<BookEntity> root = cr.from(BookEntity.class);
        cr.select(builder.count(root.get("id")));
        TypedQuery<Long> query = entityManager.createQuery(cr);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void deleteById(@Nonnull @NotNull Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<BookEntity> cr = builder.createCriteriaDelete(BookEntity.class);
        Root<BookEntity> root = cr.from(BookEntity.class);
        cr.where(builder.equal(root.get("id"), id));
        Query query = entityManager.createQuery(cr);
        query.executeUpdate();
    }
}
