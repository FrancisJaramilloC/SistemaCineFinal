package com.practica.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import controller.dao.implement.AdapterDao;
import controller.TDA.list.LinkedList;
import controller.TDA.list.ListEmptyException;
import models.Pelicula;
import models.Sala;
import controller.dao.services.PeliculaServices;
import controller.dao.services.SalaServices;

import javax.ws.rs.core.Response.Status;

@Path("/pelicula")
public class PeliculaApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAll() throws ListEmptyException, Exception {
        HashMap map = new HashMap<>();
        PeliculaServices ps = new PeliculaServices();
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
            PeliculaServices peliculaService = new PeliculaServices();
            SalaServices salaService = new SalaServices();
            Pelicula pelicula = new Pelicula();

            // Asignar datos de la película
            pelicula.setTitulo(map.get("titulo").toString());
            pelicula.setDuracion(Integer.parseInt(map.get("duracion").toString()));
            pelicula.setGenero(map.get("genero").toString());

            // Obtener la sala por su ID
            int salaId = Integer.parseInt(map.get("idSala").toString());
            LinkedList<Sala> salas = salaService.listAll();
            Sala salaEncontrada = null;

            for (int i = 0; i < salas.getSize(); i++) {
                Sala s = salas.get(i);
                if (s.getIdSala() == salaId) {
                    salaEncontrada = s;
                    break;
                }
            }

            if (salaEncontrada == null) {
                res.put("msg", "Error");
                res.put("data", "Sala no encontrada");
                return Response.status(Status.BAD_REQUEST).entity(res).build();
            }

            // Asignar la sala a la película
            pelicula.setSala(salaEncontrada);
            peliculaService.setPelicula(pelicula);
            peliculaService.save();

            res.put("msg", "OK");
            res.put("data", "Película registrada correctamente con la sala asignada");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }


    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPelicula(@PathParam("id") Integer id){
        HashMap<String, Object> map = new HashMap<>();
        PeliculaServices ps = new PeliculaServices();
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
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            PeliculaServices peliculaService = new PeliculaServices();
            SalaServices salaService = new SalaServices();
    
            int idPelicula = Integer.parseInt(map.get("idPelicula").toString());
            LinkedList<Pelicula> peliculas = peliculaService.listAll();
            Pelicula peliculaEncontrada = null;
    
            for (int i = 0; i < peliculas.getSize(); i++) {
                Pelicula p = peliculas.get(i);
                if (p.getId() == idPelicula) {
                    peliculaEncontrada = p;
                    break;
                }
            }
    
            if (peliculaEncontrada == null) {
                res.put("msg", "Error");
                res.put("data", "Película no encontrada");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
    
            // Actualizar los datos de la película
            if (map.containsKey("titulo")) {
                peliculaEncontrada.setTitulo(map.get("titulo").toString());
            }
            if (map.containsKey("duracion")) {
                peliculaEncontrada.setDuracion(Integer.parseInt(map.get("duracion").toString()));
            }
            
            // Si se envía un nuevo idSala, asignar la nueva sala
            if (map.containsKey("idSala")) {
                int idSala = Integer.parseInt(map.get("idSala").toString());
                LinkedList<Sala> salas = salaService.listAll();
                Sala salaEncontrada = null;
    
                for (int i = 0; i < salas.getSize(); i++) {
                    Sala s = salas.get(i);
                    if (s.getIdSala() == idSala) {
                        salaEncontrada = s;
                        break;
                    }
                }
    
                if (salaEncontrada == null) {
                    res.put("msg", "Error");
                    res.put("data", "Sala no encontrada");
                    return Response.status(Status.NOT_FOUND).entity(res).build();
                }
    
                peliculaEncontrada.setSala(salaEncontrada);
            }
    
            // Guardar la película actualizada
            peliculaService.setPelicula(peliculaEncontrada);
            peliculaService.update();
    
            res.put("msg", "OK");
            res.put("data", "Película actualizada correctamente");
            return Response.ok(res).build();
    
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}
    
