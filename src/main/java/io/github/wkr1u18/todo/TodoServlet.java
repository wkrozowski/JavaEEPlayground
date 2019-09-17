package io.github.wkr1u18.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wkr1u18.hello.HelloServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Todo", urlPatterns = {"/api/todos/*"})
public class TodoServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private TodoService service;
    private ObjectMapper mapper;
    /**
     * Needed by servlet container
     */
    @SuppressWarnings("unused")
    public TodoServlet() {
        this(new TodoService(), new ObjectMapper());
    }

    public TodoServlet(TodoService todoService, ObjectMapper objectMapper) {
        this.service = todoService;
        this.mapper = objectMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request got ");
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), service.findAll());
    }

}
