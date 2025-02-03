package controller.dao.services;

import controller.dao.AsientoDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Asiento;


public class AsientoServices {
    private AsientoDao obj;

    public AsientoServices() {
        obj = new AsientoDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update(Asiento asiento) throws Exception {
        return obj.update(asiento);
    }

    public LinkedList<Asiento> listAll() {
        return obj.getListAll();
    }

    public Asiento getAsiento() {
        return obj.getAsiento();
    }

    public void setAsiento(Asiento Asiento) {
        obj.setAsiento(Asiento);
    }

    public Asiento get(Integer id) throws Exception {
        return obj.get(id);
    }
}