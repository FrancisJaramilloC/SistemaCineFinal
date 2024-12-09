from flask import Flask

def create_app():
    app = Flask(__name__, template_folder='templates', instance_relative_config=False)
    app.secret_key = 'Gestor_cine'

    from routes.route import router
    app.register_blueprint(router)

    return app
