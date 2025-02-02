package models;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int duracion; // en minutos
    private Sala sala; // Relación con la sala

    // Constructor vacío
    public Pelicula() {}

    // Constructor con parámetros
    public Pelicula(int id, String titulo, String genero, int duracion, Sala sala) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.sala = sala;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
}
