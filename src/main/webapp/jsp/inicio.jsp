<%@page import="com.udep.sin2021.appsin.controllers.ServletValidaUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <!-- Etiquetas requeridas -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">    
    
    <title>Gestión de Documentos</title>

    <!-- link con rel referencia hojas de estilo-->
    <link rel ="stylesheet" href =" https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="css/normalize.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">

    <link rel="preload" href="css/style.css" as="style">
    <link rel="stylesheet" href="css/style.css">


  </head>

  <body>
        <% 
        if(session.getAttribute("nombre")==null)
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        %>

        <h2>Bienvenido :  ${nombre} ${apellidos}</h2>

        <div class="nav-bkg">
          <nav class="navegacion-principal contenedor">
            <a href="https://modasa.com.pe/">Sitio Web</a>
            <a href="#">Sobre la empresa</a>
            <a href="registro.jsp">Registrar documento</a>
            <form action="/APPsin-1/ServletCerrarSesion">
                <input type="submit" value="Cerrar sesión">
            </form>    
          </nav>
        </div>

        <main class="contenedor sombreado">


        <h3>Todos los documentos</h3>
        <sql:setDataSource var = "snapshot" driver = "org.mariadb.jdbc.Driver"
        url = "jdbc:mysql://localhost:3306/sistema"
        user = "root" password = ""/>
        
        <sql:query dataSource = "${snapshot}" var = "result">
           SELECT *,datediff(CURDATE(),Fecha) as seguimiento  FROM documento ORDER BY Fecha DESC; 
        </sql:query>

        <div style="overflow-x:auto;">
            <table id="tabla" class="display" style="width:100%">
                <thead>
                    <tr>
                       <th>Código</th>
                       <th>Nombre</th>
                       <th>Tipo</th>
                       <th>Unidad de negocio</th>
                       <th>Área</th>
                       <th>Versión</th>
                       <th>Fecha</th>
                       <th>Seguimiento</th>
                    </tr>
                 </head> <!-- acaba color encabezado -->
                 <tbody>
                 <c:forEach var = "row" items = "${result.rows}">
                    <tr>
                       <td> <a href="/APPsin-1/ServletDownloadDocumento?nombre=${row.Codigo}${row.Ruta}"><img src = "${row.Icono}"> <span><c:out value = "${row.Codigo}"/></span></a></td>
                       <td> <c:out value = "${row.Nombre}"/></td>
                       <td> <c:out value = "${row.Tipo}"/></td>
                       <td> <c:out value = "${row.Und_neg}"/></td>
                       <td> <c:out value = "${row.Area}"/></td>
                       <td> <c:out value = "${row.Version}"/></td>
                       <td> <c:out value = "${row.Fecha}"/></td>
                       <td> <c:out value = "${row.Seguimiento}"/> días</td>
                    </tr>
                 </c:forEach>
                </tbody> <!-- acaba color -->
                <tfoot>
                    <tr>
                       <th>Código</th>
                       <th>Nombre</th>
                       <th>Tipo</th>
                       <th>Unidad de negocio</th>
                       <th>Área</th>
                       <th>Versión</th>
                       <th>Fecha</th>
                       <th>Seguimiento</th>
                    </tr>
                </tfoot>                
            </table>
        </div>
           
    </main>

    <footer class="pie-de-pag">
      <p>®️ Todos los derechos reservados 2021</p>
    </footer>

        
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <!-- Tabla totales, hecho con bootstrap -->
        <script>  
                $(document).ready(function() {
                    $('#tabla').DataTable( {
                        language: {
                                    "processing": "Procesando...",
                                    "lengthMenu": "Mostrar _MENU_ registros",
                                    "zeroRecords": "No se encontraron resultados",
                                    "emptyTable": "Ningún dato disponible en esta tabla",
                                    "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                                    "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                                    "search": "Buscar:",
                                    "infoThousands": ",",
                                    "loadingRecords": "Cargando...",
                                    "paginate": {
                                        "first": "Primero",
                                        "last": "Último",
                                        "next": "Siguiente",
                                        "previous": "Anterior"
                                    },
                                    "aria": {
                                        "sortAscending": ": Activar para ordenar la columna de manera ascendente",
                                        "sortDescending": ": Activar para ordenar la columna de manera descendente"
                                    },
                                    "buttons": {
                                        "copy": "Copiar",
                                        "colvis": "Visibilidad",
                                        "collection": "Colección",
                                        "colvisRestore": "Restaurar visibilidad",
                                        "copyKeys": "Presione ctrl o u2318 + C para copiar los datos de la tabla al portapapeles del sistema. <br \/> <br \/> Para cancelar, haga clic en este mensaje o presione escape.",
                                        "copySuccess": {
                                            "1": "Copiada 1 fila al portapapeles",
                                            "_": "Copiadas %d fila al portapapeles"
                                        },
                                        "copyTitle": "Copiar al portapapeles",
                                        "csv": "CSV",
                                        "excel": "Excel",
                                        "pageLength": {
                                            "-1": "Mostrar todas las filas",
                                            "1": "Mostrar 1 fila",
                                            "_": "Mostrar %d filas"
                                        },
                                        "pdf": "PDF",
                                        "print": "Imprimir"
                                    },
                                    "autoFill": {
                                        "cancel": "Cancelar",
                                        "fill": "Rellene todas las celdas con <i>%d<\/i>",
                                        "fillHorizontal": "Rellenar celdas horizontalmente",
                                        "fillVertical": "Rellenar celdas verticalmentemente"
                                    },
                                    "decimal": ",",
                                    "searchBuilder": {
                                        "add": "Añadir condición",
                                        "button": {
                                            "0": "Constructor de búsqueda",
                                            "_": "Constructor de búsqueda (%d)"
                                        },
                                        "clearAll": "Borrar todo",
                                        "condition": "Condición",
                                        "conditions": {
                                            "date": {
                                                "after": "Despues",
                                                "before": "Antes",
                                                "between": "Entre",
                                                "empty": "Vacío",
                                                "equals": "Igual a",
                                                "notBetween": "No entre",
                                                "notEmpty": "No Vacio",
                                                "not": "Diferente de"
                                            },
                                            "number": {
                                                "between": "Entre",
                                                "empty": "Vacio",
                                                "equals": "Igual a",
                                                "gt": "Mayor a",
                                                "gte": "Mayor o igual a",
                                                "lt": "Menor que",
                                                "lte": "Menor o igual que",
                                                "notBetween": "No entre",
                                                "notEmpty": "No vacío",
                                                "not": "Diferente de"
                                            },
                                            "string": {
                                                "contains": "Contiene",
                                                "empty": "Vacío",
                                                "endsWith": "Termina en",
                                                "equals": "Igual a",
                                                "notEmpty": "No Vacio",
                                                "startsWith": "Empieza con",
                                                "not": "Diferente de"
                                            },
                                            "array": {
                                                "not": "Diferente de",
                                                "equals": "Igual",
                                                "empty": "Vacío",
                                                "contains": "Contiene",
                                                "notEmpty": "No Vacío",
                                                "without": "Sin"
                                            }
                                        },
                                        "data": "Data",
                                        "deleteTitle": "Eliminar regla de filtrado",
                                        "leftTitle": "Criterios anulados",
                                        "logicAnd": "Y",
                                        "logicOr": "O",
                                        "rightTitle": "Criterios de sangría",
                                        "title": {
                                            "0": "Constructor de búsqueda",
                                            "_": "Constructor de búsqueda (%d)"
                                        },
                                        "value": "Valor"
                                    },
                                    "searchPanes": {
                                        "clearMessage": "Borrar todo",
                                        "collapse": {
                                            "0": "Paneles de búsqueda",
                                            "_": "Paneles de búsqueda (%d)"
                                        },
                                        "count": "{total}",
                                        "countFiltered": "{shown} ({total})",
                                        "emptyPanes": "Sin paneles de búsqueda",
                                        "loadMessage": "Cargando paneles de búsqueda",
                                        "title": "Filtros Activos - %d"
                                    },
                                    "select": {
                                        "1": "%d fila seleccionada",
                                        "_": "%d filas seleccionadas",
                                        "cells": {
                                            "1": "1 celda seleccionada",
                                            "_": "$d celdas seleccionadas"
                                        },
                                        "columns": {
                                            "1": "1 columna seleccionada",
                                            "_": "%d columnas seleccionadas"
                                        }
                                    },
                                    "thousands": ".",
                                    "datetime": {
                                        "previous": "Anterior",
                                        "next": "Proximo",
                                        "hours": "Horas",
                                        "minutes": "Minutos",
                                        "seconds": "Segundos",
                                        "unknown": "-",
                                        "amPm": [
                                            "am",
                                            "pm"
                                        ]
                                    },
                                    "editor": {
                                        "close": "Cerrar",
                                        "create": {
                                            "button": "Nuevo",
                                            "title": "Crear Nuevo Registro",
                                            "submit": "Crear"
                                        },
                                        "edit": {
                                            "button": "Editar",
                                            "title": "Editar Registro",
                                            "submit": "Actualizar"
                                        },
                                        "remove": {
                                            "button": "Eliminar",
                                            "title": "Eliminar Registro",
                                            "submit": "Eliminar",
                                            "confirm": {
                                                "_": "¿Está seguro que desea eliminar %d filas?",
                                                "1": "¿Está seguro que desea eliminar 1 fila?"
                                            }
                                        },
                                        "error": {
                                            "system": "Ha ocurrido un error en el sistema (<a target=\"\\\" rel=\"\\ nofollow\" href=\"\\\">Más información&lt;\\\/a&gt;).<\/a>"
                                        },
                                        "multi": {
                                            "title": "Múltiples Valores",
                                            "info": "Los elementos seleccionados contienen diferentes valores para este registro. Para editar y establecer todos los elementos de este registro con el mismo valor, hacer click o tap aquí, de lo contrario conservarán sus valores individuales.",
                                            "restore": "Deshacer Cambios",
                                            "noMulti": "Este registro puede ser editado individualmente, pero no como parte de un grupo."
                                        }
                                    },
                                    "info": "Mostrando de _START_ a _END_ de _TOTAL_ registros totales"
                                } 
                    } );
                } );
        </script>

        
  </body>
</html>
