<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale = 1.0">
    
    
    <title>Login</title>

    <link rel="stylesheet" href="jsp/css/normalize.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">

    <link rel="preload" href="jsp/css/style.css" as="style">
    <link rel="stylesheet" href="jsp/css/style.css">

  </head>

  <body>

    <div class="logo_principal">
      <h1>MODASA S.A </h1>
      <h2>Área de Calidad</h2>
      <p>Sistema integrado de información documental</p>
    </div>

    <section class="parte-final" >

        <form class="formulario" action="ServletValidaUsuario" method="POST" autocomplete="off">
          <fieldset>
            <legend>Ingrese credenciales</legend>
            <div class="contenedor-campos">
                <div class="campo">
                  <label>Código de usuario:</label>
                  <input type="text" name="usuario" placeholder="Ingrese su código aquí">
                </div>

                <div class="campo">
                  <label>Contraseña:</label>
                  <input type="password" name="clave" placeholder="Ingrese su contraseña aquí">
                </div>

            </div> <!-- contenedor-campos -->

            <div class="alinear-derecha flex">
              <p></p>
              
              <button class="boton w-sm-100" type="submit">Iniciar Sesión</button>
            </div>

          </fieldset>
        </form>

    </section>

    <footer class="pie-de-pag">
      <p>®️ Todos los derechos reservados 2021</p>
    </footer>


    <!-- <script src="js/scripts.js"></script> -->

  </body>
</html>