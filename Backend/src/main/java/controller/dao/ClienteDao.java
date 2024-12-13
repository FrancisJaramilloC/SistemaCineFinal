package controller.dao;

import controller.dao.implement.AdapterDao;

import java.util.Arrays;

import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Cliente;

public class ClienteDao extends AdapterDao<Cliente> {
    private Cliente Cliente;
    private LinkedList<Cliente> listAll;

    public ClienteDao() {
        super(Cliente.class);
    }

    public Cliente getCliente() {
        if (Cliente == null) {
            Cliente = new Cliente();
        }
        return this.Cliente;
    }
    
    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public LinkedList<Cliente> getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getCliente().setIdCliente(id);
        persist(getCliente());
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(getCliente(), getCliente().getIdCliente() - 1);
        this.listAll = listAll();
        return true;
    }

    public Pelicula getPelicula() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPelicula'");
    }

}
