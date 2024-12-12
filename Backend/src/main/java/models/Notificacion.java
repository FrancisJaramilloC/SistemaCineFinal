package models;

import java.time.LocalDateTime;

public class Notificacion {
    private Integer idNotificacion;
    private String message;
    private LocalDateTime date;
    
    public Notificacion() {
    }

    public Notificacion(Integer idNotificacion, String message, LocalDateTime date) {
        this.idNotificacion = idNotificacion;
        this.message = message;
        this.date = date;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
