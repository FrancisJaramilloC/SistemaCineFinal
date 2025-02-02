package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Sala;
import models.Asiento;

public class SalaDao extends AdapterDao<Sala> {
    private Sala sala;
    private LinkedList<Sala> listAll;
    private AsientoDao asientoDao;

    public SalaDao() {
        super(Sala.class);
        asientoDao = new AsientoDao();
    }

    public Sala getSala() {
        if (sala == null) {
            sala = new Sala();
        }
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LinkedList<Sala> getListAll() {
        if (listAll == null) {
            listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getSala().setIdSala(id);
        persist(getSala());
        return true;
    }

    public Boolean update() throws Exception {
        merge(getSala(), getSala().getIdSala() - 1);
        listAll = listAll();
        return true;
    }

    public Sala get(Integer id) throws ListEmptyException {
        Sala sala = getListAll().get(id - 1);
        sala.setAsientos(asientoDao.getListAll()); // Cargar asientos desde AsientoDao
        return sala;
    }
}
