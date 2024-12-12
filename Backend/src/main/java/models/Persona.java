package models;

public class Persona {
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String telefono;
    private String dni;
    private String token;

    public Persona() {
    }

    public Persona(Integer idPersona, String nombre, String apellido, String correo, String clave, String telefono, String dni) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.telefono = telefono;
        this.dni = dni;
        this.token = token;
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

    public String getContrasenia() {
        return this.clave;
    }

    public void setContrasenia(String contrasenia) {
        this.clave = contrasenia;
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

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClave() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClave'");
    }

    public void setClave(String encryclave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClave'");
    }

}
