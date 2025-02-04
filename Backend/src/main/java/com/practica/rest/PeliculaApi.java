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
import models.Pelicula;
import controller.dao.services.PeliculaServices;
@Path("/pelicula")
public class PeliculaApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAll() {
        HashMap<String, Object> map = new HashMap<>();
        PeliculaServices peliculaService = new PeliculaServices();
        map.put("msg", "OK");
        map.put("data", peliculaService.listAll().toArray());
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
            Pelicula pelicula = new Pelicula();
    
            // Asignar datos de la película
            pelicula.setNombre(map.get("nombre").toString());
            pelicula.setDuracion(map.get("duracion").toString());
            pelicula.setGenero(map.get("genero").toString());
    
            // Guardar la película
            peliculaService.setPelicula(pelicula);
            peliculaService.save();
    
            res.put("msg", "OK");
            res.put("data", "Película registrada correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPelicula(@PathParam("id") Integer id){
        HashMap<String, Object> map = new HashMap<>();
        PeliculaServices peliculaService = new PeliculaServices();
        try {
            map.put("pelicula", peliculaService.get(id));
            return Response.ok(map).build();
        } catch (Exception e) {
            map.put("message", "Error al obtener película");
            map.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
        }
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePelicula(HashMap<String, Object> map){
        HashMap<String, Object> res = new HashMap<>();
        PeliculaServices peliculaService = new PeliculaServices();
        try {
            Pelicula pelicula = new Pelicula();
            pelicula.setIdPelicula(Integer.parseInt(map.get("idPelicula").toString()));
            pelicula.setNombre(map.get("nombre").toString());
            pelicula.setDuracion(map.get("duracion").toString());
            pelicula.setGenero(map.get("genero").toString());

            peliculaService.update(pelicula);
            
            res.put("message", "Película actualizada correctamente");
            res.put("data", "Actualizado");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("message", "Error al actualizar película");
            res.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}