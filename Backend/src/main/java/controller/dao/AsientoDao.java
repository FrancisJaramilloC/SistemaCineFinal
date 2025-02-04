package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Asiento;
import models.Persona;

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
        if (asiento == null || asiento.getIdAsiento() == null) {
            throw new Exception("Asiento inválido para actualizar.");
        }
        merge(asiento, asiento.getIdAsiento() - 1);
        listAll = listAll();
        return true;
    }

    public Boolean delete(int id) throws Exception {
        Asiento asiento = get(id);
        if (asiento != null) {
            asiento.setOcupado(false);
            this.update(asiento);
            this.listAll = listAll();
        }
        return false;
    }

    public Asiento get(Integer id) throws ListEmptyException {
        if (id == null || id <= 0 || id > getListAll().getSize()) {
            throw new ListEmptyException("ID de asiento inválido: " + id);
        }
        return getListAll().get(id - 1);
    }
}