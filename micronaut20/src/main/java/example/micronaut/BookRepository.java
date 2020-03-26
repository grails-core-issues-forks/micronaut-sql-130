package example.micronaut;

import io.micronaut.context.annotation.DefaultImplementation;
import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@DefaultImplementation(DefaultBookRepository.class)
public interface BookRepository {

    Long save(@Nonnull @NotBlank String name);

    @Nonnull
    Number count();

    void deleteById(@Nonnull @NotNull Long id);
}
