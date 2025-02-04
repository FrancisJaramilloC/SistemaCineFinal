package controller.dao.services;

import controller.dao.SalaDao;
import controller.TDA.list.LinkedList;
import models.Sala;
public class SalaServices {
    private SalaDao obj;
    public SalaServices() {
        obj = new SalaDao();
    }
    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update(Sala sala) throws Exception {
        return obj.update();
    }

    public LinkedList<Sala> listAll() {
        return obj.getListAll();
    }

    public Sala getSala()  {
        return obj.getSala();
    }
    
    public void setSala(Sala Sala) {
        obj.setSala(Sala);
    }

    public Sala get(Integer id) throws Exception {
        return obj.get(id);
    }
}