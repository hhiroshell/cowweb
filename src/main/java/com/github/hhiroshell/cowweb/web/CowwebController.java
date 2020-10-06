package com.github.hhiroshell.cowweb.web;

import com.github.hhiroshell.cowweb.domain.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * Remote cowsay invoker using Spring Boot
 *
 * @author hhiroshell
 */
@RestController
@RequestMapping("/cowsay")
public class CowwebController {

    @Autowired
    private CowService cow;

    /**
     * Return cowsay's 'say' message.
     *
     * @return Cowsay's 'say' message.
     */
    @RequestMapping("/say")
    public String say(@RequestParam(required = false) Optional<String> m) {
        Optional<String> env = m.map(e -> System.getenv(e));
        return cow.say(env.orElse(m.orElse("Moo!")));
    }

    /**
     * Return cowsay's 'think' message.
     *
     * @return Cowsay's 'think' message.
     */
    @RequestMapping("/think")
    public String think(@RequestParam(required = false) Optional<String> m) {
        Optional<String> env = m.map(e -> System.getenv(e));
        return cow.think(env.orElse(m.orElse("Moo!")));
    }

}
