package com.goit.Spring.Boot.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@Entity
@Table(name = "note")
@NoArgsConstructor
@AllArgsConstructor
public class Note {

     @Id
     @Column(name = "note_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;


    @Column(name = "note_title")
    private String title;

    @Column (name = "note_content")
    private String content;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
}
