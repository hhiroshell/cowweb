package com.github.hhiroshell.cowweb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.github.hhiroshell.cowweb")
public class CowwebProperties {

    private int load;

    public int getLoad() {
        return this.load;
    }

    void setLoad(int load) {
        this.load = load;
    }

}
