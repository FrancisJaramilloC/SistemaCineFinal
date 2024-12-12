package controller.dao;

import controller.dao.implement.AdapterDao;

import java.util.Arrays;

import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Pelicula;

public class PeliculaDao extends AdapterDao<Pelicula> {
    private Pelicula pelicula;
    private LinkedList<Pelicula> listAll;

    public PeliculaDao() {
        super(Pelicula.class);
    }

    public Pelicula getPelicula() {
        if (pelicula == null) {
            pelicula = new Pelicula();
        }
        return this.pelicula;
    }
    
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public linkedList<Pelicula> getListAll() {
        if(this.listAll == null) {
            this.listAll = ListAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getPelicula().setIdPelicula(id);
        persist(getPelicula());
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(getPelicula(), getPelicula().getIdpelicula() - 1);
        this.listAll = listAll();
        return true;
    }

}
