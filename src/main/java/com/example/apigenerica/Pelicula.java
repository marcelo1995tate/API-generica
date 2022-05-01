package com.example.apigenerica;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Pelicula {
    private ArrayList<Comentario> comentarios=new ArrayList<>();
    private long id;
    private String title;
    private String subtitle;
    private String img;
    private Author author;
    public void comentar(Comentario comentario){
        comentarios.add(comentario);
    }
}
