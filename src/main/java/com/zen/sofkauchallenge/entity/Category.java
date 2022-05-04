package com.zen.sofkauchallenge.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Todo> todoList = new ArrayList<>();

    public Boolean addTodo(Todo todo) {
        Boolean todoIntegrity = validateTodoIntegrity(todo);
        if (todoIntegrity) {
            this.todoList.add(todo);
            return true;
        }
        return false;
    }

    private Boolean validateTodoIntegrity(Todo todo) {
        return todo != null && todo.getTitle() != null && todo.getTitle().length() > 0;
    }
}
