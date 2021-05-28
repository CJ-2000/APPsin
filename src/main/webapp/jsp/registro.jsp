
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/normalize.css">

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">

        <link rel="preload" href="css/style.css" as="style">
        <link rel="stylesheet" href="css/style.css">
                
        <title>Registro de documento</title>
    </head>
    <body>
        <% 
        if(session.getAttribute("nombre")==null)
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        %>

        <h2>Bienvenido :  ${nombre} ${apellidos}</h2>
        
        <h1>Registrar nuevo documento</h1>
        
        
    <section class="parte-final" >

        <form class="formulario" action="/APPsin-1/ServletUploadDocumento" method="post" enctype="multipart/form-data"  accept-charset="UTF-8">
          <fieldset>
            <legend>Ingrese credenciales</legend>
            <div class="contenedor-campos">
                <div class="campo">
                  <label>Código:</label>
                  <input type="text" name="codigo" placeholder="Código del documento">
                </div>

                <div class="campo">
                  <label>Nombre del documento:</label>
                  <input type="text" name="nombre" placeholder="Nombre del documento">
                </div>
                
                <div class="campo">
                  <label>Versión:</label>
                  <input type="text" name="version" placeholder="Versión del documento">
                </div>

                <div class="campo">
                  <label>Fecha:</label>
                  <input type="text" name="fecha" placeholder="Fecha de la versión">
                </div>               
                
                <div class="campo">
                    <label class="radio">
                      <input type="radio" name="tipo" value="Procedimiento">
                      Procedimiento
                    </label>
                    <label class="radio">
                      <input type="radio" name="tipo" value="Reporte">
                      Reporte
                    </label>
                </div>
                
                <div class="campo">
                    <label class="radio">
                      <input type="radio" name="area" value="Gestion de Calidad">
                      Gestión de Calidad
                    </label>
                    <label class="radio">
                      <input type="radio" name="area" value="Mantenimiento">
                      Mantenimiento
                    </label>
                    <label class="radio">
                        <input type="radio" name="area" value="Produccion">
                      Producción
                    </label>                    
                </div>
                
                <div class="campo">
                    <select name="unidad_negocio" >
                      <option value="MODABUS">MODABUS</option>
                      <option value="MODATEC">MODATEC</option>
                      <option value="MODASUB">MODASUB</option>
                    </select>
                </div>

            </div> <!-- contenedor-campos -->

            <div class="alinear-derecha flex">
                <input type="file" name="file" />
              
                <button class="boton w-sm-100" type="submit">Registrar Documento</button>
            </div>

          </fieldset>
        </form>

    </section>        
        

    </body>
</html>
