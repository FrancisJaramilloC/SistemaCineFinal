from flask import Flask, json, flash, Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests

routerBoleto = Blueprint('routerBoleto', __name__)

# Ruta para listar todos los boletos
@routerBoleto.route('/admin/boleto/list')
def list_boletos():
    r = requests.get("http://localhost:8099/myapp/boleto/list")
    data = r.json()
    return render_template('fragmento/boleto/listaBoleto.html', list=data["data"])

@routerBoleto.route('/admin/boleto/register')
def view_register_boleto():
    r_salas = requests.get("http://localhost:8099/myapp/sala/list")
    r_peliculas = requests.get("http://localhost:8099/myapp/pelicula/list")
    salas = r_salas.json().get("data", [])
    peliculas = r_peliculas.json().get("data", [])
    
    return render_template('fragmento/boleto/registroBoleto.html', salas=salas, peliculas=peliculas)

# Ruta para procesar la compra de un boleto
@routerBoleto.route('/admin/boleto/comprar', methods=["POST"])
def comprar_boleto():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idAsiento": form["idAsiento"],
        "idSala": form["idSala"],
        "idPelicula": form["idPelicula"]
    }

    # Enviar los datos a la API para la compra del boleto
    r = requests.post("http://localhost:8099/myapp/boleto/comprar", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Boleto comprado con éxito", category='info')
    else:
        flash(str(dat["data"]), category='error')

    return redirect("/admin/boleto/list")
