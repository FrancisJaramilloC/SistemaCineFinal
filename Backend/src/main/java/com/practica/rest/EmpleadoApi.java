package com.practica.rest;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import controller.dao.services.EmpleadoServices;

@Path("/empleado")
public class EmpleadoApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpleado(){
        HashMap<String, Object> map = new HashMap<>();
        EmpleadoServices es = new EmpleadoServices();
        map.put("empleados", "Lista de empleados");
        map.put("data", es.listAll().toArray());
        if (es.listAll().isEmpty()){
            map.put("message", "No hay empleados registrados");
        }
        return Response.ok(map).build();

    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveEmpleado(HashMap<String , Object> map){
        HashMap<String, Object> res = new HashMap<>();
        EmpleadoServices es = new EmpleadoServices();

        if (map.get("nombre") == null || map.get("apellido") == null || map.get("telefono") == null || map.get("correo") == null || map.get("dni") == null || map.get("clave") == null) {
            res.put("message", "Faltan datos");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
        try {
            es.getEmpleado().setNombre(map.get("nombre").toString());
            es.getEmpleado().setApellido(map.get("apellido").toString());
            es.getEmpleado().setCorreo(map.get("correo").toString());
            es.getEmpleado().setTelefono(map.get("telefono").toString());
            es.getEmpleado().setDni(map.get("dni").toString());
            es.getEmpleado().setClave(map.get("contrasenia").toString());
            
            es.save();
            res.put("message", "Empleado registrado correctamente");
            res.put("data", "Guardado");
            res.put("token", es.getEmpleado().getToken()); 
            return Response.ok(res).build();
           } catch (Exception e) {
            res.put("message", "Error al registrar empleado");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
    }
}