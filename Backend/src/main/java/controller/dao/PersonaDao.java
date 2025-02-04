package controller.dao;

import controller.TDA.list.LinkedList;
import controller.dao.implement.AdapterDao;
import models.Persona;

public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;
    private LinkedList<Persona> listAll;

    public PersonaDao() {
        super(Persona.class);
    }

    // Obtener objeto Persona (si está vacío, crea el objeto)
    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListAll() {
        if (listAll == null) {
            listAll = listAll();
        }
        return listAll;
    }

    // Método para guardar una nueva Persona
    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        persona.setId(id);
        this.persist(persona);
        this.listAll = listAll();
        return true;
    }

    // Método para actualizar una Persona existente
    public Boolean update() throws Exception {
        this.merge(getPersona(), getPersona().getId() - 1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(int id) throws Exception {
        Persona persona = get(id); 
        if (persona != null) {
            persona.setExiste(false); 
            this.update(); 
            this.listAll = listAll(); 
        }
        return false; 
    }

    public Persona get(int id) throws Exception {
        for (int i = 0; i < getListAll().getSize(); i++) {
            Persona currentPersona = getListAll().get(i);
            if (currentPersona.getId() == id) {
                return currentPersona;
            }
        }
        return null;
    }
}
