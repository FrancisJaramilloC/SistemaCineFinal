package models;
public class Asiento {
    private Integer idAsiento;
    private Boolean ocupado;

    public Asiento() {
        this.ocupado = false;
    }

    public Asiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
        this.ocupado = false;
    }

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
