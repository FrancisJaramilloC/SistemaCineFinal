package controller.dao.services;

import controller.dao.PeliculaDao;
import controller.TDA.list.LinkedList;
import models.Pelicula;
import controller.TDA.list.ListEmptyException;

public class PeliculaServices {
    private PeliculaDao obj;
    public ProyectoServices() {
        obj = new PeliculaDao();
    }  

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Proyecto> listAll() {
        return obj.getListAll();
    }

    public Proyecto getProyecto() {
        return obj.getProyecto();
    }

    public void setProyecto(Proyecto proyecto) {
        obj.setProyecto(proyecto);
    }

    public Proyecto get(Integer id) throws Exception {
        return obj.get(id);
    }
}
