package example.micronaut

trait ConfigurationFixture implements MySQLContainerFixture {

    Map<String, Object> getConfiguration() {
        Map<String, Object> m = [:]
        if (specName) {
            m['spec.name'] = specName
        }
        m += mySQLConfiguration
        m
    }

    String getSpecName() {
        null
    }

}