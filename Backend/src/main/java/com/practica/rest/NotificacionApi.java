package com.practica.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Notificacion;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

@Path("/notificaciones")
public class NotificacionApi {

    @POST
    @Path("/enviar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response enviarNotificacion(HashMap<String, Object> map) {
 
        Integer idNotificacion = (Integer) map.get("idNotificacion");
        String message = (String) map.get("message");

        if (idNotificacion == null || message == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Faltan parámetros para la notificación.")
                           .build();
        }

        Notificacion notificacion = new Notificacion(idNotificacion, message, LocalDateTime.now());

        HashMap<String, Object> response = new HashMap<>();
        response.put("idNotificacion", notificacion.getIdNotificacion());
        response.put("message", notificacion.getMessage());
        response.put("date", notificacion.getDate().toString());

        return Response.ok(response).build();
    }
}


