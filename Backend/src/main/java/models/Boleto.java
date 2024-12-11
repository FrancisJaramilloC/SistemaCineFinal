package models;

public class Boleto{
    private Integer idBoleto;
    private String infoFuncion;
    private String infoAsiento;
    private boolean precio;

    public Boleto(){
    }

    public Boleto(Integer idBoleto, String infoFuncion, String infoAsiento, boolean precio){
        this.idBoleto = idBoleto;
        this.infoFuncion = infoFuncion;
        this.infoAsiento = infoAsiento;
        this.precio = precio;
    }

    public Integer getIdBoleto() {
        return this.idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getInfoFuncion() {
        return this.infoFuncion;
    }

    public void setInfoFuncion(String infoFuncion) {
        this.infoFuncion = infoFuncion;
    }

    public String getInfoAsiento() {
        return this.infoAsiento;
    }

    public void setInfoAsiento(String infoAsiento) {
        this.infoAsiento = infoAsiento;
    }

    public boolean isPrecio() {
        return this.precio;
    }

    public void setPrecio(boolean precio) {
		this.precio = precio;
	}

}

