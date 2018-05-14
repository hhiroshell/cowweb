package jp.gr.java_conf.cowweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AccessCounter extends CachingConfigurerSupport {

    @Autowired
    RedisTemplate<String, Integer> redis;

    @Autowired
    private ApplicationProperties properties;

    private static String REDIS_KEY_VERSION_COUNTER;

    @PostConstruct
    public void init() {
        REDIS_KEY_VERSION_COUNTER = "version_counter_" + properties.getVersion();
    }

    public int increment() {
        ValueOperations<String, Integer> operation = redis.opsForValue();
        Integer count = getCount() + 1;
        operation.set(REDIS_KEY_VERSION_COUNTER, count);
        return count.intValue();
    }

    public int getCount() {
        ValueOperations<String, Integer> operation = redis.opsForValue();
        Integer count = operation.get(REDIS_KEY_VERSION_COUNTER);
        if (count == null) {
            count = 0;
        }
        return count;
    }

}
