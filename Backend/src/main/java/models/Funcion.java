package models;

public class Funcion {
    private Integer idFuncion;
    private String sala;
    private String tipoSala;
    private String capacidad;
    private Integer asientos;
    private Date fecha;
    private String horario;

    public Funcion(){
    }

    public Funcion(Integer idFuncion, String sala, String tipoSala, String capacidad, Integer asientos, Date fecha, String horario){
        this.idFuncion = idFuncion;
        this.sala = sala;
        this.tipoSala = tipoSala;
        this.capacidad = capacidad;
        this.asientos = asientos;
        this.fecha = fecha;
        this.horario = horario;
    }
    
	public Integer getIdFuncion() {
		return this.idFuncion;
	}

	public void setIdFuncion(Integer idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTipoSala() {
		return this.tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public String getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getAsientos() {
		return this.asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
