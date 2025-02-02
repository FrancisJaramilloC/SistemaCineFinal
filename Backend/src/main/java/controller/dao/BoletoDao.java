package controller.dao;

import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Boleto;
import models.Pelicula;
import models.Sala;
import models.Asiento;

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

    public Boolean update() throws Exception {
        merge(getBoleto(), getBoleto().getIdBoleto() - 1);
        listAll = listAll();
        return true;
    }

    public Boleto get(Integer id) throws ListEmptyException {
        return getListAll().get(id - 1);
    }

    // Método para vender un boleto
    public Boolean venderBoleto(Pelicula pelicula, Sala sala, Asiento asiento) throws Exception {
        Boleto boleto = new Boleto();
        boleto.setPelicula(pelicula);
        boleto.setSala(sala);
        boleto.setAsiento(asiento);

        setBoleto(boleto);
        save();

        return true;
    }
}