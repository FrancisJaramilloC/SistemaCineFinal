package models;

public class Empleado extends Persona {
    private Integer idEmpleado;
    private String sueldo;


    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String sueldo) {
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
    }

    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

       public String getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

}
