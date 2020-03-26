package example.micronaut

trait LeakageDetector extends RepositoriesFixture {
    boolean hasLeakage() {
        if (bookRepository.count() > 0) {
            println "there are still books"
        }
        bookRepository.count() > 0
    }
}