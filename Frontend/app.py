from flask import Flask

def create_app():
    app = Flask(__name__, instance_relative_config=False)
    with app.app_context():
        from routes.router import router
        from routes.routerSala import routerSala
        from routes.routerBoleto import routerBoleto
        from routes.routerPelicula import routerPelicula
        from routes.routerAsientos import routerAsiento
        app.register_blueprint(router)
        app.register_blueprint(routerSala)
        app.register_blueprint(routerBoleto)
        app.register_blueprint(routerPelicula)
        app.register_blueprint(routerAsiento)

    return app
