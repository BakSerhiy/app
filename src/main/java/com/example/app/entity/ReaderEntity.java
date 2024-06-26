package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="readers")
public class ReaderEntity {

    @Id
    @Column(name="reader_id")
    private Long id;

    @Column(name="bookname")
    private String bookname;

    @Column(name="author")
    private String author;

    @Column(name="genre")
    private String genre;

}
