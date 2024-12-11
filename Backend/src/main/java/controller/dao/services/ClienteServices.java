package controller.dao.services;

import controller.dao.ClienteDao;
import controller.TDA.list.LinkedList;
import models.Cliente;
import controller.TDA.list.ListEmptyException;


public class ClienteServices {
    private ClienteDao obj;

    public ClienteServices() {
        obj = new ClienteDao();
    }  

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Cliente> listAll() {
        return obj.getListAll();
    }

    public Cliente getCliente() {
        return obj.getCliente();
    }

    public void setCliente(Cliente Cliente) {
        obj.setCliente(Cliente);
    }

    public Cliente get(Integer id) throws Exception {
        return obj.get(id);
    }
}
