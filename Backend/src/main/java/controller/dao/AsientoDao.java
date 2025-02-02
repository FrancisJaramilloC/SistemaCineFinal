package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Asiento;

public class AsientoDao extends AdapterDao<Asiento> {
    private Asiento asiento;
    private LinkedList<Asiento> listAll;

    public AsientoDao() {
        super(Asiento.class);
    }

    public Asiento getAsiento() {
        if (asiento == null) {
            asiento = new Asiento();
        }
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public LinkedList<Asiento> getListAll() {
        if (listAll == null) {
            listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getAsiento().setIdAsiento(id);
        persist(getAsiento());
        return true;
    }
    

    public Boolean update(Asiento asiento) throws Exception {
        merge(getAsiento(), getAsiento().getIdAsiento() - 1);
        listAll = listAll();
        return true;
    }

    public Asiento get(Integer id) throws ListEmptyException {
        return getListAll().get(id - 1);
    }
    
}