package models;

public class Boleto {
    private Integer idBoleto;
    private String nombrePelicula;
    private String nombreSala;
    private Integer idAsiento;

    public Boleto() {}

    public Boleto(Integer idBoleto, String nombrePelicula, String nombreSala, Integer idAsiento) {
        this.idBoleto = idBoleto;
        this.nombrePelicula = nombrePelicula;
        this.nombreSala = nombreSala;
        this.idAsiento = idAsiento;
    }

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }
}
