package com.todo.service;

import com.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public TodoService() {
        // Données de test
        todos.add(new Todo(counter.incrementAndGet(),
                "Apprendre DevSecOps",
                "Comprendre CI/CD, Docker, et sécurité",
                false));
        todos.add(new Todo(counter.incrementAndGet(),
                "Configurer GitHub Actions",
                "Mettre en place le pipeline",
                false));
    }

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

    public Todo getTodoById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Todo createTodo(Todo todo) {
        todo.setId(counter.incrementAndGet());
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            return todo;
        }
        return null;
    }

    public boolean deleteTodo(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}
