package com.zen.sofkauchallenge.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private Long id;
    private String title;
    private boolean done;
    private Long categoryFK;
}
