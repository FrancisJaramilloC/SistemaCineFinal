package controller.dao.services;

import controller.dao.PeliculaDao;
import controller.TDA.list.LinkedList;
import models.Pelicula;
import controller.TDA.list.ListEmptyException;

public class PeliculaServices {
    private PeliculaDao obj;
    public PeliculaServices() {
        obj = new PeliculaDao();
    }  

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Pelicula> listAll() {
        return obj.listAll();
    }

    public Pelicula getPelicula() {
        return obj.getPelicula();
    }

    public void setProyecto(Pelicula pelicula) {
        obj.setPelicula(pelicula);
    }

    public Pelicula get(Integer id) throws Exception {
        return obj.get(id);
    }
}
