package example.micronaut

class BookRepositorySpec extends ApplicationContextSpecification {

    void "it is possible to save a book"() {
        when:
        Long id = bookRepository.save("getting things done")

        then:
        bookRepository.count() == old(bookRepository.count()) + 1
        id

        cleanup:
        bookRepository.deleteById(id)
    }
}
