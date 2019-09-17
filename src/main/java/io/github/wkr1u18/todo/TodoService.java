package io.github.wkr1u18.todo;

import io.github.wkr1u18.lang.LangRepository;

import java.util.List;

class TodoService {
    private TodoRepository repository;

    TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    TodoService() {
        this(new TodoRepository());
    }

    List<Todo> findAll() {
        return repository.findAll();
    }
}
