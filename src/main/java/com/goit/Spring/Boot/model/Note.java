package com.goit.Spring.Boot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// модель нотатки
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
}
