import json
from flask import Flask, Blueprint, render_template, request, redirect, url_for, flash, session
import requests

route = Blueprint('route', __name__)

@route.route('/')
def home():
    return render_template('index.html')

@route.route('inicio')
def inicio():
    return render_template('inicio.html')
