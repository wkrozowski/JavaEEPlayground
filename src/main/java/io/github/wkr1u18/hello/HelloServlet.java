package io.github.wkr1u18.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "hello", urlPatterns = {"/api"})
public class HelloServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private HelloService service;

    /**
     * Needed by servlet container
     */
    @SuppressWarnings("unused")
    public HelloServlet() {
        this(new HelloService());
    }

    HelloServlet(HelloService service) {
        this.service = service;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request got with parameters: " + req.getParameterMap());
        String nameParameter = req.getParameter(NAME_PARAM);
        String langParameter = req.getParameter(LANG_PARAM);
        Integer langId = null;
        try {
            langId = Integer.valueOf(langParameter);
        } catch (NumberFormatException nfe) {
            logger.warn("Non-numeric lang id used " + langParameter);
        }
        resp.getWriter().write(service.prepareGreeting(nameParameter, langId));
    }

}
