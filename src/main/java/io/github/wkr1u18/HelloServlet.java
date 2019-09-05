package io.github.wkr1u18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request got with parameters: " + req.getParameterMap());
        String contents = Optional.ofNullable(req.getParameter("name")).orElse("World");
        resp.getWriter().write("<h1>Hello " + contents + "!</h1>");
    }

}
