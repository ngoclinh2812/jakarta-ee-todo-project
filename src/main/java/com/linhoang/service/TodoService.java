package com.linhoang.service;

import com.linhoang.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Admin
 */
@Transactional
public class TodoService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public Todo createTodo (Todo todo) {
        entityManager.persist(todo);
        return todo;
    }
    
    public Todo updateTodo (Todo todo) {
        entityManager.merge(todo);
        return todo;
    }
    
    public Todo findTodoById (Long id) {
        return entityManager.find(Todo.class, id);
    }
    
    public List<Todo> getTodos () {
        return entityManager.createQuery("select t from Todo t", Todo.class).getResultList();
    }
    
}
