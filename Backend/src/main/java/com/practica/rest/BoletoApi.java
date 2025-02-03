package com.practica.rest;

import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.dao.services.BoletoServices;
import controller.dao.services.AsientoServices;
import controller.dao.services.SalaServices;
import controller.dao.services.PeliculaServices;
import models.Boleto;
import models.Asiento;
import models.Sala;
import models.Pelicula;

@Path("/boleto")
public class BoletoApi {

    @Path("/comprar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarBoleto(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            Integer idAsiento = Integer.parseInt(map.get("idAsiento").toString());
            Integer idSala = Integer.parseInt(map.get("idSala").toString());
            Integer idPelicula = Integer.parseInt(map.get("idPelicula").toString());

            AsientoServices asientoService = new AsientoServices();
            SalaServices salaService = new SalaServices();
            PeliculaServices peliculaService = new PeliculaServices();
            BoletoServices boletoService = new BoletoServices();

            // Obtener el asiento
            Asiento asiento = asientoService.get(idAsiento);
            if (asiento == null || asiento.getIdAsiento() == null) {
                res.put("msg", "Error");
                res.put("data", "El asiento no existe o no tiene ID asignado.");
                return Response.status(Status.BAD_REQUEST).entity(res).build();
            }

            if (asiento.isOcupado()) {
                res.put("msg", "Error");
                res.put("data", "El asiento ya está ocupado");
                return Response.status(Status.BAD_REQUEST).entity(res).build();
            }

            // Obtener la sala y la película
            Sala sala = salaService.get(idSala);
            Pelicula pelicula = peliculaService.get(idPelicula);

            // Crear el boleto
            Boleto boleto = new Boleto();
            boleto.setNombrePelicula(pelicula.getNombre());
            boleto.setNombreSala(sala.getNombre());
            boleto.setIdAsiento(idAsiento);

            // Guardar el boleto
            boletoService.setBoleto(boleto);
            boletoService.save();

            // Actualizar el estado del asiento
            asiento.setOcupado(true);
            asientoService.update(asiento);

            res.put("msg", "OK");
            res.put("data", "Boleto comprado con éxito");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}
