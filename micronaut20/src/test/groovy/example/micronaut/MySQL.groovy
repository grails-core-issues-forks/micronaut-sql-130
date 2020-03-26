package example.micronaut

import org.testcontainers.containers.MySQLContainer

class MySQL {
    static MySQLContainer mysqlContainer

    static init() {
        if (mysqlContainer == null) {
            mysqlContainer = new MySQLContainer()
                    .withDatabaseName("deeplinkingDb")
                    .withUsername("foo")
                    .withPassword("secret")
            mysqlContainer.start()
        }
    }

    static void destroy() {
        if (mysqlContainer != null) {
            mysqlContainer.stop()
        }
    }
}
