package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
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
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LinkedList<Pelicula> getListAll() {
        if (listAll == null) {
            listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getPelicula().setIdPelicula(id);
        persist(getPelicula());
        return true;
    }

    public Boolean update(Pelicula pelicula) throws Exception {
        merge(pelicula, pelicula.getIdPelicula() - 1);
        listAll = listAll();
        return true;
    }

    public Pelicula get(Integer id) throws Exception {
        return getListAll().get(id - 1);
    }
}
