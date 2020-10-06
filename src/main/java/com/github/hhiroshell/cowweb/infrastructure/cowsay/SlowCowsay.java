package com.github.hhiroshell.cowweb.infrastructure.cowsay;

import com.github.hhiroshell.cowweb.CowwebProperties;
import com.github.hhiroshell.cowweb.domain.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Profile("slow")
public class SlowCowsay extends Cowsay implements CowService {

    @Autowired
    private CowwebProperties properties;

    @Override
    protected String getRandomCowfile() {
        Random rand = new Random();
        int index = 0;
        for (int i = 0; i < properties.getLoad(); i++) {
            for (int j = 0; j < properties.getLoad(); j++) {
                index = rand.nextInt(cowfiles.size());
            }
        }
        return cowfiles.get(index);
    }

}
