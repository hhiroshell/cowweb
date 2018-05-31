package jp.gr.java_conf.cowweb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jp.gr.java-conf.hhiroshell.cowweb")
class ApplicationProperties {

    private String version;

    private String redisHost;

    private int redisPort;

    String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        this.redisPort = redisPort;
    }

}
