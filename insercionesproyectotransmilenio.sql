insert into troncales values('A','caracas',0.8,'KM');
insert into troncales values('B','Autopista',12.0,'KM');
insert into estaciones values('calle 76','A','T','E');
insert into estaciones values('portal 80','B','T','P');
insert into rutas values('A52',null,'T');
insert into rutas values('B10',null,'T');
insert into estaciones_rutas values('A52','calle 76',7);
insert into estaciones_rutas values('B10','calle 76',1);
insert into horarios_rutas values('L-V','A52',1,5,CAST('5:00:00.0000000' AS TIME),CAST('19:00:00.0000000' AS TIME));
insert into horarios_rutas values('S','A52',6,null,CAST('5:00:00.0000000' AS TIME),CAST('19:00:00.0000000' AS TIME));