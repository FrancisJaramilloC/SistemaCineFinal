package models;

public class Persona {
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String telefono;
    private String dni;

    public Persona() {
    }

    public Persona(Integer idPersona, String nombre, String apellido, String correo, String contrasenia, String telefono, String dni) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.dni = dni;
    }

    public Integer getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
