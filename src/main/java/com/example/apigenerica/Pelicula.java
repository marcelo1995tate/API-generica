package com.example.apigenerica;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pelicula {
    private long id;
    private String title;
    private String subtitle;
    private String img;
    private Author author;

}
