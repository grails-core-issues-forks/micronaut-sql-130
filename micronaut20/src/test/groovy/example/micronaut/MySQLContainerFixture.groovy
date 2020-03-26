package example.micronaut

trait MySQLContainerFixture {

    Map<String, Object> getMySQLConfiguration() {
        if (MySQL.mysqlContainer == null || !MySQL.mysqlContainer.isRunning()) {
            MySQL.init()
        }
        [
                'datasources.default.url': MySQL.mysqlContainer.getJdbcUrl(),
                'datasources.default.password': MySQL.mysqlContainer.getPassword(),
                'datasources.default.username': MySQL.mysqlContainer.getUsername()
        ]
    }
}
