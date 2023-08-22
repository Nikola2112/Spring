package com.goit.Spring.Boot.entities;


import lombok.Data;

@Data
public class Note {

    private Long id;

    private String title;

    private String content;

    public void getId(Long nextId) {
    }
}
