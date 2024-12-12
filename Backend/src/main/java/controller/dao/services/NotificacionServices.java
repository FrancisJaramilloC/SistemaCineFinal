package controller.dao.services;

import controller.dao.NotificacionDao;
import controller.TDA.list.LinkedList;
import models.Notificacion;


public class NotificacionServices {
    private NotificacionDao obj;

    public NotificacionServices() {
        obj = new NotificacionDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Notificacion> listAll() {
        return obj.getListAll();
    }

    public Notificacion getNotificacion() {
        return obj.getNotificacion();
    }

    public void setNotificacion(Notificacion notificacion) {
        obj.setNotificacion(notificacion);
    }

    public Notificacion get(Integer id) throws Exception {
        return obj.get(id);
    }
}
