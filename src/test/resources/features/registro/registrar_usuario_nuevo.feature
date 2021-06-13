# language: es
Característica: Realizar el registro de un nuevo usuario en la pagina de carnival.

  @TestCase1
  Esquema del escenario: Registro Exitoso de un nuevo usuario
    Dado que yo cargo la url de pruebas
    Cuando intento registrar un nuevo usuario
      | <idCaso> | <emailUsuario> | <password> | <primerNombre> | <primerApellido> | <dia> | <ano> | <mes> | <pais> | <genero> | <area> | <telefono> | <resultadoEsperado> |
    Entonces Verifico el <resultadoEsperado> del registro de usuario
    Ejemplos:
      | idCaso | emailUsuario       | password    | primerNombre | primerApellido | dia | ano  | mes      | pais     | genero | area   | telefono  | resultadoEsperado      |
      | 1      | prueba7@correo.com | Cl@ve123456 | PrimerNombre | PrimerApellido | 12  | 1980 | February | Colombia | Male   | 150415 | 999999999 | THANKS FOR SIGNING UP! |