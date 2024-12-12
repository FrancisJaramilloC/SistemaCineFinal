package controller.dao.services;

import controller.dao.PeliculaDao;
import controller.TDA.list.LinkedList;
import models.Pelicula;
import controller.TDA.list.ListEmptyException;


public class PeliculaServices {
    private PeliculaDao obj;
<<<<<<< HEAD

=======
>>>>>>> Rama_Fermin
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
<<<<<<< HEAD
        return obj.getListAll();
=======
        return obj.listAll();
>>>>>>> Rama_Fermin
    }

    public Pelicula getPelicula() {
        return obj.getPelicula();
    }

<<<<<<< HEAD
    public void setPelicula(Pelicula Pelicula) {
        obj.setPelicula(Pelicula);
=======
    public void setProyecto(Pelicula pelicula) {
        obj.setPelicula(pelicula);
>>>>>>> Rama_Fermin
    }

    public Pelicula get(Integer id) throws Exception {
        return obj.get(id);
    }
}
