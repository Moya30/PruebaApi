CREATE TABLE "usuario" (
  "id_usuario" integer,
  "nomb_usua" varchar,
  "ape_usua" varchar,
  "carg_emp_usua" varchar,
  "nomb_emp_usua" varchar,
  "telf_usua" varchar,
  "correo_usua" varchar,
  "pass_usua" varchar
);

CREATE TABLE "foto_usuario" (
  "id_foto_usua" integer PRIMARY KEY,
  "nomb_foto" varchar,
  "url_foto" varchar,
  "id_usuario" integer
);

CREATE TABLE "proyecto" (
  "id_proyecto" integer PRIMARY KEY,
  "compartir" varchar,
  "nomb_proyecto" varchar,
  "desc_proyecto" varchar,
  "fecha_ini" timestamp,
  "fecha_fin" timestamp,
  "id_estado" integer,
  "id_usuario" integer,
  "id_icono" integer
);

CREATE TABLE "icono" (
  "id_icono" integer PRIMARY KEY,
  "nomb_ico" varchar,
  "url_ico" varchar
);

CREATE TABLE "estado" (
  "id_estado" integer PRIMARY KEY,
  "nomb_estado" varchar
);

ALTER TABLE "usuario" ADD FOREIGN KEY ("id_usuario") REFERENCES "foto_usuario" ("id_usuario");

ALTER TABLE "proyecto" ADD FOREIGN KEY ("id_estado") REFERENCES "estado" ("id_estado");

ALTER TABLE "proyecto" ADD FOREIGN KEY ("id_icono") REFERENCES "icono" ("id_icono");

ALTER TABLE "proyecto" ADD FOREIGN KEY ("id_usuario") REFERENCES "usuario" ("id_usuario");
