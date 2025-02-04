package com.practica.rest;

import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import controller.TDA.list.ListEmptyException;
import controller.dao.services.AsientoServices;
import controller.dao.services.PersonaServices;

import javax.ws.rs.core.Response.Status;

@Path("/asiento")
public class AsientoApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAll() throws ListEmptyException, Exception {
        HashMap map = new HashMap<>();
        AsientoServices ps = new AsientoServices();
        map.put("msg", "OK");
        map.put("data", ps.listAll().toArray());
        if (ps.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap map) {

        HashMap res = new HashMap<>();
        Gson g = new Gson();
        String a = g.toJson(map);
        System.out.println("Datos recibidos: " + a);

        try {
            AsientoServices ps = new AsientoServices();
            ps.getAsiento().setOcupado(Boolean.parseBoolean(map.get("ocupado").toString()));
            ps.save();
            res.put("msg", "OK");
            res.put("data", "Asiento registrada correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error en sav data: " + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAsiento(@PathParam("id") Integer id){
        HashMap<String, Object> map = new HashMap<>();
        AsientoServices ps = new AsientoServices();
        try {
            map.put("persona", ps.get(id));
            return Response.ok(map).build();
        } catch (Exception e) {
            map.put("message", "Error al obtener persona");
            map.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
        }
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAsiento(HashMap<String, Object> map){
        HashMap<String, Object> res = new HashMap<>();
        AsientoServices ps = new AsientoServices();
        try {
            ps.getAsiento().setOcupado(Boolean.parseBoolean(map.get("ocupado").toString()));
            res.put("message", "Asiento actualizada correctamente");
            res.put("data", "Actualizado");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("message", "Error al actualizar persona");
            res.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            AsientoServices ps = new AsientoServices();
            Integer id = Integer.parseInt(map.get("idAsiento").toString());

            Boolean success = ps.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Persona no encontrada");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            System.out.println("Error en delete data" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}