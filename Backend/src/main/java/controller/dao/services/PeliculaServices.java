package controller.dao.services;

import controller.dao.PeliculaDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Pelicula;


public class PeliculaServices {
    private PeliculaDao obj;
    
    public PeliculaServices() {
        obj = new PeliculaDao();
    }
    
    public LinkedList<Pelicula> listAll() {
        return obj.getListAll();
    }

    public Pelicula get(Integer id) throws Exception {
        return obj.get(id);
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update(Pelicula pelicula) throws Exception {
        return obj.update(pelicula);
    }

    public void setPelicula(Pelicula pelicula) {
        obj.setPelicula(pelicula);
    }
}