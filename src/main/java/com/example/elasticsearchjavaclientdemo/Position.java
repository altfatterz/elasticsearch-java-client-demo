package com.example.elasticsearchjavaclientdemo;

import lombok.Data;

@Data
public class Position {

    private String id;

    private String name;

    public Position(String id, String name) {
        this.id = id;
        this.name = name;
    }
}