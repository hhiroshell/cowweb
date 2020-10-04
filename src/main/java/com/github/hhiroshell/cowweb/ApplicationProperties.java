package com.github.hhiroshell.cowweb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.github.hhiroshell.cowweb")
class ApplicationProperties {

    private String version;

    String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
