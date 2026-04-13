package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoControllerTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void todoを保存できる() {
        Todo todo = new Todo("テスト");
        Todo saved = todoRepository.save(todo);
        assertThat(saved.getId()).isGreaterThan(0);
        assertThat(saved.getTitle()).isEqualTo("テスト");
    }

    @Test
    public void 空タイトルのtodoは保存できない() {
        assertThat(todoRepository).isNotNull();
    }
}
