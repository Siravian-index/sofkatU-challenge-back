package com.zen.sofkauchallenge.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TodoDTO {
    private Long id;
    @NotBlank(message = "Title must be provided")
    private String title;
    private boolean done;
    @NotNull(message = "categoryFK must be provided")
    private Long categoryFK;
}
