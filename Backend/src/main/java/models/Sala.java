package models;

import controller.TDA.list.LinkedList;
public class Sala {
    private Integer idSala;
    private String nombre;
    private int capacidad;
    private LinkedList<Asiento> asientos;
    private Pelicula pelicula;  // Nuevo atributo para la película

    public Sala() {
        this.asientos = new LinkedList<>();
    }

    public Sala(Integer idSala, String nombre, int capacidad, Pelicula pelicula) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.asientos = new LinkedList<>();
        this.pelicula = pelicula;  // Asignación de la película
    }

    // Getters y Setters
    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LinkedList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(LinkedList<Asiento> asientos) {
        this.asientos = asientos;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
