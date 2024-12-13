import json
from flask import Flask, Blueprint, render_template, request, redirect, url_for, flash, session
import requests

router = Blueprint('route', __name__)

@router.route('/')
def home():
    return render_template('template.html')

@router.route('/inicio')
def inicio():
    return render_template('inicio.html')

@router.route('/login')
def login():
    return render_template('login/inicioSesion.html')

@router.route('/inicioSesion', methods=['POST'])
def procesar_login():
    # Definir encabezado y cuerpo de la solicitud
    headers = {"Content-Type": "application/json"}
    form_data = request.form
    payload = {
        "correo": form_data.get("correo"),
        "clave": form_data.get("clave")
    }

    # Realizar la solicitud POST al servicio de autenticación
    response = requests.post("http://localhost:8090/myapp/persona/iniciosesion", headers=headers, json=payload)
    
    # Procesar la respuesta
    if response.status_code == 200:
        response_data = response.json()
        session['token'] = response_data.get("token")
        session['usuario'] = form_data.get("correo")
        session["idPersona"] = response_data.get("idPersona")
        
        # Redirigir al dashboard en caso de login exitoso
        return redirect(url_for('router.dashboard'))
    
    # En caso de error en el login, renderizar la vista de inicio de sesión con el mensaje de error
    error_message = response.json().get("error", "Error al iniciar sesión")
    return render_template('login/inicioSesion.html', error=error_message)