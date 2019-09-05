package io.github.wkr1u18;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private HelloService service = new HelloService();

    @Test
    public void test_prepareGreeting_null_returnsFallbackValue() {
        String result = service.prepareGreeting(null);
        String expected = "Hello " + HelloService.FALLBACK_NAME+"!";
        assertEquals(result, expected);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() {
        String name = "test";
        String result = service.prepareGreeting(name);
        String expected = "Hello test!";
        assertEquals(result, expected);
    }
}
