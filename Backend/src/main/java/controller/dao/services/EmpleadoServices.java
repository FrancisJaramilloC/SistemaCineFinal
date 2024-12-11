package controller.dao.services;

import controller.dao.EmpleadoDao;
import controller.TDA.list.LinkedList;
import models.Empleado;
import controller.TDA.list.ListEmptyException;


public class EmpleadoServices {
    private EmpleadoDao obj;

    public EmpleadoServices() {
        obj = new EmpleadoDao();
    }  

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Empleado> listAll() {
        return obj.getListAll();
    }

    public Empleado getEmpleado() {
        return obj.getEmpleado();
    }

    public void setEmpleado(Empleado Empleado) {
        obj.setEmpleado(Empleado);
    }

    public Empleado get(Integer id) throws Exception {
        return obj.get(id);
    }
}
