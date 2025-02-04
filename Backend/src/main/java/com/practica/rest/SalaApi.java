package com.practica.rest;

import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.dao.services.SalaServices;
import controller.dao.services.AsientoServices;
import controller.dao.services.PeliculaServices;
import models.Sala;
import models.Asiento;
import models.Pelicula;
import controller.TDA.list.LinkedList; 
import controller.TDA.list.ListEmptyException;

import java.util.List;

@Path("/sala")
public class SalaApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAll() throws ListEmptyException, Exception {
        HashMap map = new HashMap<>();
        SalaServices ps = new SalaServices();
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
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            SalaServices salaService = new SalaServices();
            AsientoServices asientoService = new AsientoServices();
            PeliculaServices peliculaService = new PeliculaServices(); 
            Sala sala = new Sala();

            sala.setNombre(map.get("nombre").toString());
            sala.setCapacidad(Integer.parseInt(map.get("capacidad").toString()));
            Gson gson = new Gson();
            List<Integer> asientoIds = gson.fromJson(
                    gson.toJson(map.get("asientos")),
                    new TypeToken<List<Integer>>() {
                    }.getType());

            LinkedList<Asiento> todosLosAsientos = asientoService.listAll();
            LinkedList<Asiento> asientosSeleccionados = new LinkedList<>();
            for (int i = 0; i < todosLosAsientos.getSize(); i++) {
                Asiento asiento = todosLosAsientos.get(i);
                if (asientoIds.contains(asiento.getIdAsiento())) {
                    asientosSeleccionados.add(asiento);
                }
            }
            sala.setAsientos(asientosSeleccionados);

            Integer peliculaId = Integer.parseInt(map.get("idPelicula").toString());
            Pelicula pelicula = peliculaService.get(peliculaId); 

            sala.setPelicula(pelicula);
            salaService.setSala(sala);
            salaService.save();
            res.put("msg", "OK");
            res.put("data", "Sala registrada con los asientos y película especificados");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSala(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        SalaServices salaService = new SalaServices();
        AsientoServices asientoService = new AsientoServices();
        PeliculaServices peliculaService = new PeliculaServices();
    
        try {
            if (!map.containsKey("idSala")) {
                res.put("message", "Error");
                res.put("data", "ID de sala no proporcionado");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            Integer idSala = Integer.parseInt(map.get("idSala").toString());
            Sala sala = salaService.get(idSala);
            if (sala == null) {
                res.put("message", "Error");
                res.put("data", "Sala no encontrada");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }

            if (sala.getIdSala() == null) {
                System.out.println("La sala no tiene ID asignado.");
                res.put("message", "Error");
                res.put("data", "La sala no tiene un ID válido.");
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
            }
            
            if(map.containsKey(sala.getIdSala())) {
                sala.setIdSala(Integer.parseInt(map.get("idSala").toString()));
            }
            if (map.containsKey("nombre")) {
                sala.setNombre(map.get("nombre").toString());
            }
            if (map.containsKey("capacidad")) {
                sala.setCapacidad(Integer.parseInt(map.get("capacidad").toString()));
            }
    
            if (map.containsKey("asientos")) {
                Gson gson = new Gson();
                List<Integer> asientoIds = gson.fromJson(
                    gson.toJson(map.get("asientos")),
                    new TypeToken<List<Integer>>() {}.getType()
                );
    
                LinkedList<Asiento> asientosSeleccionados = new LinkedList<>();
                for (Integer idAsiento : asientoIds) {
                    Asiento asiento = asientoService.get(idAsiento);
                    if (asiento != null) {
                        asientosSeleccionados.add(asiento);
                    }
                }
                sala.setAsientos(asientosSeleccionados);
            }

            if (map.containsKey("idPelicula")) {
                Integer peliculaId = Integer.parseInt(map.get("idPelicula").toString());
                Pelicula pelicula = peliculaService.get(peliculaId);
                if (pelicula != null) {
                    sala.setPelicula(pelicula);
                }
            }
    
            salaService.update(sala);
            res.put("message", "Sala actualizada correctamente");
            res.put("data", sala);
            return Response.ok(res).build();
    
        } catch (Exception e) {
            e.printStackTrace(); 
            res.put("message", "Error al actualizar sala");
            res.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}