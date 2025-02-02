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
    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Pelicula> listAll() {
        return obj.getListAll();
    }

    public Pelicula getPelicula()  {
        return obj.getPelicula();
    }
    
    public void setPelicula(Pelicula Pelicula) {
        obj.setPelicula(Pelicula);
    }


    public Pelicula get(Integer id) throws Exception {
        return obj.get(id);
    }


}