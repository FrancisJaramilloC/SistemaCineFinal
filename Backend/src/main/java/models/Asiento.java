package models;

public class Asiento {
    private Integer idAsiento;
    private int numero;
    private boolean ocupado;

    public Asiento() {
    }

    public Asiento(Integer idAsiento, int numero, boolean ocupado) {
        this.idAsiento = idAsiento;
        this.numero = numero;
        this.ocupado = ocupado;
    }

    // Getters y Setters
    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}