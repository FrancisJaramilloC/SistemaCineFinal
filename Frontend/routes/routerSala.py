from flask import Flask, json, flash, Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests

routerSala = Blueprint('routerSala', __name__)

# Ruta para listar todas las salas
@routerSala.route('/admin/sala/list')
def list_salas():
    r = requests.get("http://localhost:8099/myapp/sala/list")
    data = r.json()
    return render_template('fragmento/sala/listaSalas.html', list=data["data"])


@routerSala.route('/admin/sala/edit/<int:id>')
def view_edit_sala(id):
    r1 = requests.get(f"http://localhost:8099/myapp/sala/list/{id}")
    data1 = r1.json()

    if r1.status_code == 200:

        return render_template('fragmento/sala/editar.html', sala=data1["data"])
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/sala/list")

@routerSala.route('/admin/sala/register')
def view_register_sala():

    r_peliculas = requests.get("http://localhost:8099/myapp/pelicula/list")
    peliculas = r_peliculas.json().get("data", [])
    
    r_asientos = requests.get("http://localhost:8099/myapp/asiento/list")
    asientos = r_asientos.json().get("data", [])

    return render_template('fragmento/sala/registroSalas.html', peliculas=peliculas, asientos=asientos)


@routerSala.route('/admin/sala/save', methods=["POST"])
def save_sala():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "nombre": form["nombre"],
        "capacidad": form["capacidad"],
        "asientos": form.getlist("asientos[]"),  
        "idPelicula": form["idPelicula"]  
    }


    r = requests.post("http://localhost:8099/myapp/sala/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Sala guardada correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')

    return redirect("/admin/sala/list")

