package controller.dao;

import controller.dao.implement.AdapterDao;

import java.util.Arrays;

import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Empleado;

<<<<<<< HEAD
public class EmpleadoDao extends AdapterDao<Empleado> {
    private Empleado Empleado;
    private LinkedList<Empleado> listAll;
=======
public class EmpleadoDao extends AdapterDao<Pelicula> {
    private Pelicula pelicula;
    private LinkedList<Pelicula> listAll;
>>>>>>> Rama_Fermin

    public EmpleadoDao() {
        super(Empleado.class);
    }

    public Empleado getEmpleado() {
        if (Empleado == null) {
            Empleado = new Empleado();
        }
        return this.Empleado;
    }
    
    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }

    public LinkedList<Empleado> getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        getEmpleado().setIdEmpleado(id);
        persist(getEmpleado());
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(getEmpleado(), getEmpleado().getIdEmpleado() - 1);
        this.listAll = listAll();
        return true;
    }

}
