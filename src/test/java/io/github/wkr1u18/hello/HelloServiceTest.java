package io.github.wkr1u18.hello;


import io.github.wkr1u18.hello.HelloService;
import io.github.wkr1u18.lang.Lang;
import io.github.wkr1u18.lang.LangRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
private final static String WELCOME= "Hello";
private final static String FALLBACK_ID_WELCOME = "Hola";
    @Test
    public void test_prepareGreeting_nullName_returnsFallbackName() {
        var mockRepository = getMockRepository();
        var service = new HelloService(mockRepository);
        String result = service.prepareGreeting(null, "-1");
        String expected = HelloService.FALLBACK_LANG.getWelcomeMsg() + " " + HelloService.FALLBACK_NAME+"!";
        assertEquals(result, expected);
    }

    private LangRepository getMockRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.of(new Lang(null, WELCOME, "-1"));
            }
        };
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() {
        var mockRepository = getMockRepository();
        var service = new HelloService(mockRepository);
        String result = service.prepareGreeting("test", "-1");
        String expected = HelloService.FALLBACK_LANG.getWelcomeMsg() + " test!";
        assertEquals(result, expected);
    }

    @Test
    public void test_prepareGreeting_nullLang_returnsGreetingWithFallbackLang() {
        var mockRepository = fallbackLangIdRepository();
        var service = new HelloService(mockRepository);
        String result = service.prepareGreeting(null, null);
        String expected = FALLBACK_ID_WELCOME + " " + HelloService.FALLBACK_NAME+"!";
        assertEquals(result, expected);
    }

    private LangRepository fallbackLangIdRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                if(id.equals(HelloService.FALLBACK_LANG.getId())) {

                    return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
                }
                return Optional.empty();
            }
        };
    }

    @Test
    public void test_prepareGreeting_notNumberLang_returnsGreetingWithFallbackLang() {
        var mockRepository = fallbackLangIdRepository();
        var service = new HelloService(mockRepository);
        String result = service.prepareGreeting(null, "abc");
        String expected = FALLBACK_ID_WELCOME + " " + HelloService.FALLBACK_NAME+"!";
        assertEquals(result, expected);
    }

    @Test
    public void test_prepareGreeting_nonExistingLang_returnsGreetingWithFallbackLang() {
        var mockRepository = new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.empty();
            }
        };
        var service = new HelloService(mockRepository);
        String result = service.prepareGreeting(null, "2");
        String expected = HelloService.FALLBACK_LANG.getWelcomeMsg() + " " + HelloService.FALLBACK_NAME+"!";
        assertEquals(result, expected);
    }
    
}
