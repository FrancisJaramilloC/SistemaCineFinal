from flask import Flask, json, flash, Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests

routerAsiento = Blueprint('routerAsiento', __name__)

# Ruta para listar todos los asientos
@routerAsiento.route('/admin/asiento/list')
def list_asientos():
    r = requests.get("http://localhost:8099/myapp/asiento/list")
    data = r.json()
    return render_template('fragmento/asiento/listaAsiento.html', list=data["data"])

# Ruta para ver un asiento específico
@routerAsiento.route('/admin/asiento/list/<int:id>')
def view_edit_asiento(id):
    r1 = requests.get(f"http://localhost:8099/myapp/asiento/list/{id}")
    data1 = r1.json()

    if r1.status_code == 200:
        return render_template('fragmento/asiento/editarAsiento.html', asiento=data1["data"])
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/asiento/list")

# Ruta para registrar un asiento
@routerAsiento.route('/admin/asiento/register')
def view_register_asiento():
    return render_template('fragmento/asiento/registroAsiento.html')

# Ruta para guardar un asiento
@routerAsiento.route('/admin/asiento/save', methods=["POST"])
def save_asiento():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "ocupado": form["ocupado"],
    }

    r = requests.post("http://localhost:8099/myapp/asiento/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Asiento guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')

    return redirect("/admin/asiento/list")


@routerAsiento.route('/admin/asiento/update', methods=["POST"])
def update_asiento():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "ocupado": form["ocupado"],
    }

    r = requests.post("http://localhost:8099/myapp/asiento/update", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Asiento actualizado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')

    return redirect("/admin/asiento/list")

