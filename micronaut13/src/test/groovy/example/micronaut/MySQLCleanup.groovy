package example.micronaut

import org.spockframework.runtime.extension.AbstractGlobalExtension

class MySQLCleanup extends AbstractGlobalExtension {

    @Override
    void stop() {

        MySQL.destroy()
    }

}
