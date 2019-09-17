package io.github.wkr1u18.todo;

import io.github.wkr1u18.hello.HibernateUtil;

import java.util.List;
import java.util.Optional;

class TodoRepository {
    List<Todo> findAll() {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Todo", Todo.class).list();
        transaction.commit();
        session.close();
        return result;
    }

    public Optional<Todo> findById(Integer id) {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Todo.class, id);
        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }

    public Todo toggleTodo(Integer id) {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Todo.class, id);
        result.setDone(!result.getDone());
        transaction.commit();
        session.close();
        return result;
    }

    public Todo addTodo(Todo newTodo) {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.persist(newTodo);
        transaction.commit();
        session.close();
        return newTodo;
    }
}
