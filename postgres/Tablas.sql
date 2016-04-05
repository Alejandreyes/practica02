CREATE TABLE public.usuario
(
  usuario character varying(15) NOT NULL,
  contrasenia character varying(15),
  CONSTRAINT "pk_Usuario" PRIMARY KEY (usuario)
);
CREATE TABLE public.prestador
(
  nombre character varying(20),
  apellidos character varying(20),
  correo character varying(25),
  calificacion integer,
  usuario character varying(15) NOT NULL,
  CONSTRAINT "pk_Consumidor" PRIMARY KEY (usuario)
);

CREATE TABLE public.consumidor
(
  usuario character varying(15) NOT NULL,
  nombre character varying(20),
  apellidos character varying(20),
  correo character varying(25),
  calificacion integer,
  CONSTRAINT "pk_Prestador" PRIMARY KEY (usuario)
);