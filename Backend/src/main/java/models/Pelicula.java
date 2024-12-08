package models;

public class Pelicula {
    private Integer idPelicula;
    private String titulo;
    private String duracion;
    private String genero;
    private String clasificacion;
    private String descripcion;

    public Pelicula(){
    }

    public Pelicula(Integer idPelicula, String titulo, String duracion, String genero, String clasificacion, String descripcion){
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
    }

    public Integer getIdPelicula() {
        return this.idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return this.clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
