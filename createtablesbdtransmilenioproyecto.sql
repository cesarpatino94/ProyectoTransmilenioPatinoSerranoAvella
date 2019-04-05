USE bdtransmilenioproyecto;
create table troncales(
id_troncal varchar(1) NOT NULL,
nombre_troncal varchar(45) NOT NULL,
longitud_troncal decimal(5,2) NOT NULL,
unidades_longitud varchar(2) NOT NULL
);

create table estaciones(
nombre_estacion varchar(30) NOT NULL,
id_troncal varchar(1),
tipo_estacion varchar(1) NOT NULL,
tipo_cabecera varchar(1));

create table rutas(
id_ruta varchar(10) not null,
nombre_ruta varchar(45),
tipo_bus varchar(1) not null
);
create table estaciones_rutas(
id_ruta varchar(10) NOT NULL,
nombre_estacion varchar(30) NOT NULL,
orden_ruta int NOT NULL
);

create table horarios_rutas(
id_horario varchar(3) NOT NULL,
id_ruta varchar(10) NOT NULL,
dia_inicio INT NOT NULL,
dia_fin INT,
hora_inicio time NOT NULL,
hora_fin time NOT NULL
);


 