package com.example.todo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody String title) {
        Todo todo = new Todo(title);
        return todoRepository.save(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody String title) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTitle(title);
        return todoRepository.save(todo);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoRepository.deleteById(id);
        return "削除しました: " + id;
    }
}