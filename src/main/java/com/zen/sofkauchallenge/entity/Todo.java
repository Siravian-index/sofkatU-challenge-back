package com.zen.sofkauchallenge.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean done;
    private Long categoryFK;
}
