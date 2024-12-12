package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import models.Notificacion;


public class NotificacionDao extends AdapterDao<Notificacion> {
    private Notificacion notificacion;
    private LinkedList<Notificacion> listAll;

    public NotificacionDao() {
        super(Notificacion.class);
    }

    public Notificacion getNotificacion() {
        if (notificacion == null) {
            notificacion = new Notificacion();
        }
        return this.notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public LinkedList<Notificacion> getListAll() {
        if (this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getNotificacion().setIdNotificacion(id);
        persist(getNotificacion());
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(getNotificacion(), getNotificacion().getIdNotificacion() - 1);
        this.listAll = listAll();
        return true;
    }
}
