package example.micronaut

import io.micronaut.context.ApplicationContext

trait RepositoriesFixture {
    abstract ApplicationContext getApplicationContext()

    BookRepository getBookRepository() {
        applicationContext.getBean(BookRepository)
    }
}
