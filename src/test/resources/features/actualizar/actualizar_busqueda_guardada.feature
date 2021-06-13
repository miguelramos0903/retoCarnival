# language: es
Característica: Actualizar la consulta de viaje de un usuario en la pagina de carnival.

  @TestCase1
  Esquema del escenario: Actualizar la busqueda guardada
    Dado que yo cargo la url de pruebas para actualizar cruceros
    Cuando intento actualizar la busqueda guardada
      | <idCaso> | <destinoCrucero> | <mensaje_Confirmacion> | <emailUsuario> | <password> | <numeroHabitaciones> |
    Entonces Verifico el <mensaje_Pie_De_Pagina> del registro de actualizado
    Y Verifico el <mensaje_Confirmacion> del registro actualizado
    Ejemplos:
      | idCaso | destinoCrucero | mensaje_Confirmacion | emailUsuario      | password    | numeroHabitaciones | mensaje_Pie_De_Pagina                                 |
      | 1      | The Bahamas    | Confirm Information  | prueba@correo.com | Cl@ve123456 | 4                  | For assistance with your Carnival Cruise, please call |