package com.github.hhiroshell.cowweb;

import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {Cowweb.class},
        initializers = {ConfigFileApplicationContextInitializer.class})
@WebAppConfiguration
public class CowwebControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testSay() throws Exception {
        mockMvc.perform(get("/say"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(new StringContains(getBubble("Moo!", SayOrThink.SAY))));
    }

    @Test
    public void testThink() throws Exception {
        mockMvc.perform(get("/think"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(new StringContains(getBubble("Moo!", SayOrThink.THINK))));
    }

    private String getBubble(String moosage, SayOrThink sot) {
        StringBuilder builder = new StringBuilder(" ");
        for (int i = 0; i < moosage.length() + 2; i++) {
            builder.append("_");
        }
        builder.append("\n");
        switch (sot) {
            case SAY:
                builder.append("<");
                break;
            case THINK:
                builder.append("(");
                break;
        }
        builder.append(" ");
        builder.append(moosage);
        builder.append(" ");
        switch (sot) {
            case SAY:
                builder.append(">");
                break;
            case THINK:
                builder.append(")");
                break;
        }
        builder.append("\n");
        builder.append(" ");
        for (int i = 0; i < moosage.length() + 2; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    private enum SayOrThink {
        SAY,
        THINK,
    }

}