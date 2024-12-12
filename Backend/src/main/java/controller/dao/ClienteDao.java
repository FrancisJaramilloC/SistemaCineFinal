package controller.dao;

import controller.dao.implement.AdapterDao;

import java.util.Arrays;

import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Pelicula;

public class PeliculaDao extends AdapterDao<Pelicula> {
    private Pelicula pelicula;
    private LinkedList<Pelicula> listAll;

    public ProyectoDaoU() {
        super(Proyecto.class);
    }

    public Proyecto getProyecto() {
        if (pelicula == null) {
            pelicula = new Pelicula();
        }
        return this.proyecto;
    }
    
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public linkedList<Proyecto> getListAll() {
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

    public Pelicula getPelicula() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPelicula'");
    }

}
