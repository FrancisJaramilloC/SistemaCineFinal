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

import controller.dao.services.ClienteServices;

@Path("/cliente")
public class ClienteApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(){
        HashMap<String, Object> map = new HashMap<>();
        ClienteServices cs = new ClienteServices();
        map.put("clientes", "Lista de clientes");
        map.put("data", cs.listAll().toArray());
        if (cs.listAll().isEmpty()){
            map.put("message", "No hay clientes registrados");
        }
        return Response.ok(map).build();

    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCliente(HashMap<String , Object> map){
        HashMap<String, Object> res = new HashMap<>();
        ClienteServices cs = new ClienteServices();

        if (map.get("nombre") == null || map.get("apellido") == null || map.get("telefono") == null || map.get("correo") == null || map.get("dni") == null || map.get("clave") == null) {
            res.put("message", "Faltan datos");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
        try {
            cs.getCliente().setNombre(map.get("nombre").toString());
            cs.getCliente().setApellido(map.get("apellido").toString());
            cs.getCliente().setCorreo(map.get("correo").toString());
            cs.getCliente().setTelefono(map.get("telefono").toString());
            cs.getCliente().setDni(map.get("dni").toString());
            cs.getCliente().setClave(map.get("contrasenia").toString());
            
            cs.save();
            res.put("message", "Cliente registrado correctamente");
            res.put("data", "Guardado");
            res.put("token", cs.getCliente().getToken()); 
            return Response.ok(res).build();
           } catch (Exception e) {
            res.put("message", "Error al registrar cliente");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(HashMap<String , Object> map){
        HashMap<String, Object> res = new HashMap<>();
        ClienteServices cs = new ClienteServices();

        if (map.get("nombre") == null || map.get("apellido") == null || map.get("telefono") == null || map.get("correo") == null || map.get("dni") == null || map.get("clave") == null) {
            res.put("message", "Faltan datos");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
        try {
            cs.getCliente().setNombre(map.get("nombre").toString());
            cs.getCliente().setApellido(map.get("apellido").toString());
            cs.getCliente().setCorreo(map.get("correo").toString());
            cs.getCliente().setTelefono(map.get("telefono").toString());
            cs.getCliente().setDni(map.get("dni").toString());
            cs.getCliente().setClave(map.get("contrasenia").toString());
            
            cs.update();
            res.put("message", "Cliente actualizado correctamente");
            res.put("data", "Actualizado");
            res.put("token", cs.getCliente().getToken()); 
            return Response.ok(res).build();
           } catch (Exception e) {
            res.put("message", "Error al actualizar cliente");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
    }
}