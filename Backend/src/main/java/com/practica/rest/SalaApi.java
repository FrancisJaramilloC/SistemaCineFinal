package com.practica.rest;

import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.dao.services.SalaServices;
import controller.dao.services.AsientoServices;
import models.Sala;
import models.Asiento;
import controller.TDA.list.LinkedList; // Tu implementación de LinkedList
import java.util.List;

@Path("/sala")
public class SalaApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAll() {
        HashMap<String, Object> map = new HashMap<>();
        SalaServices salaService = new SalaServices();
        map.put("msg", "OK");
        map.put("data", salaService.listAll().toArray());
        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            SalaServices salaService = new SalaServices();
            AsientoServices asientoService = new AsientoServices();
            Sala sala = new Sala();
    
            // Asignar datos de la sala
            sala.setNombre(map.get("nombre").toString());
            sala.setCapacidad(Integer.parseInt(map.get("capacidad").toString()));
    
            // Obtener la lista de IDs de asientos desde la solicitud JSON
            Gson gson = new Gson();
            List<Integer> asientoIds = gson.fromJson(
                gson.toJson(map.get("asientos")),
                new TypeToken<List<Integer>>() {}.getType()
            );
    
            // Obtener todos los asientos guardados en la BD
            LinkedList<Asiento> todosLosAsientos = asientoService.listAll(); 
            
            // Filtrar solo los asientos que coincidan con los IDs proporcionados
            LinkedList<Asiento> asientosSeleccionados = new LinkedList<>();
            for (int i = 0; i < todosLosAsientos.getSize(); i++) {
                Asiento asiento = todosLosAsientos.get(i);
                if (asientoIds.contains(asiento.getIdAsiento())) {
                    asientosSeleccionados.add(asiento);
                }
            }
    
            // Asignar los asientos seleccionados a la sala
            sala.setAsientos(asientosSeleccionados);
    
            // Guardar la sala con los asientos seleccionados
            salaService.setSala(sala);
            salaService.save();
    
            res.put("msg", "OK");
            res.put("data", "Sala registrada con los asientos especificados");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
    
}    