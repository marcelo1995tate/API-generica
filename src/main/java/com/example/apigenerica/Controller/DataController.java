package com.example.apigenerica.Controller;
        import com.example.apigenerica.Author;
        import com.example.apigenerica.Comentario;
        import com.example.apigenerica.Pelicula;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
class DataController {
    private ArrayList<Pelicula> peliculas=new ArrayList<>();

    private long id=0;

    DataController(){
        cargarPelis();
        cargarPelis();
        cargarPelis();
        cargarPelis();
        cargarPelis();
    }

    @RequestMapping(value = "data",method = RequestMethod.GET)
    public List<Pelicula> getAll(){
        return peliculas;
    }
    @RequestMapping(value = "data/{id}",method = RequestMethod.GET)
    public Pelicula findById(@PathVariable int id){
        for(Pelicula aux :peliculas){
            if(aux.getId()==id)
                return aux;
        }
        return null;
    }

    @RequestMapping(value = "comentar",method = RequestMethod.POST)
    public void comentar(@RequestBody Comentario comentario){
        Pelicula pelicula=findById(comentario.getIdPelicula());
        pelicula.comentar(comentario);
        peliculas.remove(findById(comentario.getIdPelicula()));
        peliculas.add(pelicula);
    }


    private void cargarPelis(){
        Author author=new Author();
        author.setName("Marcelo "+ id);

        Pelicula pelicula=new Pelicula();
        pelicula.setId(id);
        pelicula.setTitle("video "+id);
        pelicula.setSubtitle("subvideo "+id);
        pelicula.setImg("https://ep01.epimg.net/elpais/imagenes/2019/10/30/album/1572424649_614672_1572453030_noticia_normal.jpg");
        pelicula.setAuthor(author);
        id++;
        peliculas.add(pelicula);
    }
}