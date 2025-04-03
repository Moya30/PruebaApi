Apis:

Login:

URL: localhost:8081/api/login

{
    "correo": "juan.perez@example.com",
    "password": "password123"
}


Listar usuarios:

localhost:8081/api/usuarios

Crear usuarios:

localhost:8081/api/usuarios/crear

{
    "nombUsuario": "Freddy",
    "apeUsuario": "Moya Pacheco",
    "cargEmp": "Gerente",
    "nombEmp": "Pachetec",
    "telfUsua": "912345678",
    "correoUsua": "prueba@gmail.codm",
    "password": "abcd1234"
}


Listar estados:

localhost:8081/api/estados

 Crear estados:
 
localhost:8081/api/estados/crear

{
        "nombEstado": "Planificación"
        
 }


 Listar proyectos:

 localhost:8081/api/proyectos 

 Crear proyectos:

 localhost:8081/api/proyectos

 { 
  "idProyecto": "ATA-5",
  "nombreProyecto": "Nuevo Proyecto",
  "descProyecto": "Descripción del proyecto",
  "fechaIni": "2025-04-01T00:00:00",
  "fechaFin": "2025-04-30T00:00:00",
  "compartir": "false",
  "idEstado": 1,
  "idUsuario": 1,
  "idIcono": 1
}

