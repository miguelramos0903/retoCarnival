# language: es
Característica: Realizar la consulta de viaje de un usuario en la pagina de carnival.

  @TestCase1
  Esquema del escenario: Buscar cruceros a bahamas
    Dado que yo cargo la url de pruebas para buscar cruceros
    Cuando intento buscar cruceros a bahamas
      | <idCaso> | <destinoCrucero> |
    Entonces Verifico el resultado de la busqueda <resultadoEsperado>
    Ejemplos:
      | idCaso | destinoCrucero | resultadoEsperado                       |
      | 1      | The Bahamas    | The Bahamas from Charleston, SC - SAVED |
