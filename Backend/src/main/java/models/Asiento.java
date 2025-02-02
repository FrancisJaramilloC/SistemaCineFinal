package models;

public class Asiento {
    private Integer idAsiento;
    private Boolean ocupado;

    public Asiento() {
        this.ocupado = false;
    }

    // Asegúrate de que el ID no sea null
    public Asiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
        this.ocupado = false;
    }

    // Getters y Setters
    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
}
