package models;

public class Boleto {
    private Integer idBoleto;
    private Pelicula pelicula;
    private Sala sala;
    private Asiento asiento;

    public Boleto() {
    }

    public Boleto(Integer idBoleto, Pelicula pelicula, Sala sala, Asiento asiento) {
        this.idBoleto = idBoleto;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = asiento;
    }

    // Getters y Setters
    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
}