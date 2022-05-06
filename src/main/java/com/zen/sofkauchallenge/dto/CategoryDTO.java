package com.zen.sofkauchallenge.dto;

import com.zen.sofkauchallenge.entity.Todo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    private Long id;
    @NotBlank(message = "Title must be provided")
    private String title;
    private List<Todo> todoList = new ArrayList<>();
}
