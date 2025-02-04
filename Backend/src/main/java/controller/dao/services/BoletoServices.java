package controller.dao.services;

import controller.dao.BoletoDao;
import controller.TDA.list.LinkedList;
import models.Boleto;
public class BoletoServices {
    private BoletoDao obj;

    public BoletoServices() {
        obj = new BoletoDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<Boleto> listAll() {
        return obj.getListAll();
    }

    public Boleto getBoleto() {
        return obj.getBoleto();
    }

    public void setBoleto(Boleto boleto) {
        obj.setBoleto(boleto);
    }
}