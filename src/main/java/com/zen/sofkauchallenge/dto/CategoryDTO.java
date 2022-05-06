package com.zen.sofkauchallenge.dto;

import com.zen.sofkauchallenge.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    private Long id;
    private String title;
    private List<Todo> todoList = new ArrayList<>();
}
