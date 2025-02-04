from flask import Flask, json, flash, Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests

routerPelicula = Blueprint('routerPelicula', __name__)

# Ruta para listar todas las películas
@routerPelicula.route('/admin/pelicula/list')
def list_peliculas():
    r = requests.get("http://localhost:8099/myapp/pelicula/list")
    data = r.json()
    return render_template('fragmento/pelicula/listaPelicula.html', list=data["data"])

# Ruta para ver una película específica
@routerPelicula.route('/admin/pelicula/list/<int:id>')
def view_edit_pelicula(id):
    r1 = requests.get(f"http://localhost:8099/myapp/pelicula/list/{id}")
    data1 = r1.json()

    if r1.status_code == 200:
        return render_template('fragmento/pelicula/editarPelicula.html', pelicula=data1["data"])
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/pelicula/list")

# Ruta para registrar una nueva película
@routerPelicula.route('/admin/pelicula/register')
def view_register_pelicula():
    return render_template('fragmento/pelicula/registroPelicula.html')

# Ruta para guardar una película
@routerPelicula.route('/admin/pelicula/save', methods=["POST"])
def save_pelicula():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "nombre": form["nombre"],
        "duracion": form["duracion"],
        "genero": form["genero"],
    }

    r = requests.post("http://localhost:8099/myapp/pelicula/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Película guardada correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')

    return redirect("/admin/pelicula/list")

# Ruta para actualizar una película
@routerPelicula.route('/admin/pelicula/update', methods=["POST"])
def update_pelicula():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idPelicula": form["id"],
        "nombre": form["nombre"],
        "duracion": form["duracion"],
        "genero": form["genero"],
    }

    r = requests.post("http://localhost:8099/myapp/pelicula/update", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Película actualizada correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')

    return redirect("/admin/pelicula/list")
