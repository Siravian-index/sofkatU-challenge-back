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

    public Category addTodo(Todo todo) {
        this.todoList.add(todo);
        return this;
    }

}
