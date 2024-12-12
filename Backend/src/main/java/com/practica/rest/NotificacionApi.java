package com.practica.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import controller.dao.services.NotificacionServices;

@Path("/notificacion")
public class NotificacionApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotificacion() {
        HashMap<String, Object> map = new HashMap<>();
        NotificacionServices ns = new NotificacionServices();
        map.put("notifications", "Lista de notificaciones");
        map.put("data", ns.listAll().toArray());
        if (ns.listAll().isEmpty()) {
            map.put("message", "No hay notificaciones registradas");
        }
        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveNotificacion(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        NotificacionServices ns = new NotificacionServices();

        if (map.get("message") == null) {
            res.put("message", "Falta el mensaje");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }

        try {
            ns.getNotificacion().setMessage(map.get("message").toString());
            ns.getNotificacion().setDate(LocalDateTime.now());
            ns.save();
            res.put("message", "Notificación registrada correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("message", "Error al registrar la notificacion");
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        }
    }
}
