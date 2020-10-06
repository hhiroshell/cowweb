package com.github.hhiroshell.cowweb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.github.hhiroshell.cowweb")
class ApplicationProperties {

    private int load;

    int getLoad() {
        return this.load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

}
