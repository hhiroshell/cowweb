package com.github.hhiroshell.cowweb.infrastructure.cowsay;

import com.github.hhiroshell.cowweb.domain.service.CowService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Profile("default")
public class Cowsay implements CowService {

    private static final String br = System.getProperty("line.separator");

    protected static final List<String> cowfiles;

    static {
        List<String> infelicities = Arrays.asList(new String[]{"head-in", "telebears", "sodomized"});
        List<String> c = new ArrayList<>();
        Arrays.stream(com.github.ricksbrown.cowsay.Cowsay.say(new String[]{"-l"}).split(br)).forEach(f -> {
            if (!infelicities.contains(f)) {
                c.add(f);
            }
        });
        cowfiles = Collections.unmodifiableList(c);
    }

    @Override
    public String say(String moo) {
        return com.github.ricksbrown.cowsay.Cowsay.say(new String[]{"-f", getRandomCowfile(), moo});
    }

    @Override
    public String think(String moo) {
        return com.github.ricksbrown.cowsay.Cowsay.think(new String[]{"-f", getRandomCowfile(), moo});
    }

    protected String getRandomCowfile() {
        return cowfiles.get(new Random().nextInt(cowfiles.size()));
    }

}
