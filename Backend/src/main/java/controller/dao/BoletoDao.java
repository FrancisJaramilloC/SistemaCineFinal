package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import models.Boleto;
public class BoletoDao extends AdapterDao<Boleto> {
    private Boleto boleto;
    private LinkedList<Boleto> listAll;

    public BoletoDao() {
        super(Boleto.class);
    }

    public Boleto getBoleto() {
        if (boleto == null) {
            boleto = new Boleto();
        }
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public LinkedList<Boleto> getListAll() {
        if (listAll == null) {
            listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getBoleto().setIdBoleto(id);
        persist(getBoleto());
        return true;
    }
}