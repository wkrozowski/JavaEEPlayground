package io.github.wkr1u18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "World";
    static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, String lang) {
        Long langId;
        try {
            langId = Optional.ofNullable(lang).map(Long::valueOf).orElse(FALLBACK_LANG.getId());
        }
        catch(NumberFormatException nfe) {
            logger.warn("Non-numeric lang used: " + lang);
            langId = FALLBACK_LANG.getId();
        }
        String welcomeMessage = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMessage();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMessage + " " + nameToWelcome + "!";
    }
}
