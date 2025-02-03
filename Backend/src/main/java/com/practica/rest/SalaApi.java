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
import controller.dao.services.EmpleadoServices;
import controller.dao.services.PeliculaServices;
import models.Sala;
import models.Asiento;
import models.Pelicula;
import controller.TDA.list.LinkedList; // Tu implementación de LinkedList
import java.util.List;

@Path("/sala")
public class SalaApi {
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
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            SalaServices salaService = new SalaServices();
            AsientoServices asientoService = new AsientoServices();
            PeliculaServices peliculaService = new PeliculaServices();  // Servicios para manejar película
            
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

            // Obtener la película por ID
            Integer peliculaId = Integer.parseInt(map.get("idPelicula").toString());
            Pelicula pelicula = peliculaService.get(peliculaId);  // Obtener la película desde el servicio

            // Asignar la película a la sala
            sala.setPelicula(pelicula);

            // Guardar la sala con los asientos y la película
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
}