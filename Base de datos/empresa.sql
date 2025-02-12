
use empresa_m;

create table depart
(dept_no int primary key constraint ch_Depart_dept_no check (dept_no between 10 and 100),
dnombre varchar(40) unique not null,
loc varchar(40) not null);

create table emple
(emp_no int primary key constraint ch_emp_no check (emp_no > 0),
apellido varchar(40) not null,
oficio enum ('EMPLEADO', 'VENDEDOR', 'DIRECTOR', 'ANALISTA', 'PROGRAMADOR', 'PRESIDENTE') not null,
dir int,
fecha_alt date not null,
salario float not null constraint ch_salario check (salario >= 600),
comision float constraint ch_comision check (comision >= 0),
dept_no int default 10 not null,
constraint fk_dir_Emple foreign key(dir) references emple(emp_no) on update cascade,
constraint fk_dept_no_Emple foreign key(dept_no) references depart(dept_no) on update cascade);

INSERT INTO DEPART VALUES (10, 'CONTABILIDAD', 'SEVILLA');
INSERT INTO DEPART VALUES (20, 'INVESTIGACIÓN', 'MADRID');
INSERT INTO DEPART VALUES (30, 'VENTAS', 'BARCELONA');

INSERT INTO EMPLE VALUES (7839, 'REY', 'PRESIDENTE', NULL, '2014/11/17', 3900, 0, 10);
INSERT INTO EMPLE VALUES (7698, 'NEGRO', 'DIRECTOR', 7839, '2014/05/01', 2200, 0, 30);
INSERT INTO EMPLE VALUES (7738, 'CEREZO', 'DIRECTOR', 7839, '2014/09/06', 2210, 0, 10);
INSERT INTO EMPLE VALUES (7566, 'JIMÉNEZ', 'DIRECTOR', 7839, '2014/02/04', 2300, 0, 20);
INSERT INTO EMPLE VALUES (7499, 'ARROYO', 'VENDEDOR', 7698, '2013/02/20', 1200, 240, 30);
INSERT INTO EMPLE VALUES (7521, 'SALA', 'VENDEDOR', 7698, '2014/02/22', 960, 390, 30);
INSERT INTO EMPLE VALUES (7654, 'MARTÍN', 'VENDEDOR', 7698, '2014/09/29', 965, 1000, 30);
INSERT INTO EMPLE VALUES (7844, 'TOVAR', 'VENDEDOR', 7698, '2014/09/08', 1100, 0, 30);
INSERT INTO EMPLE VALUES (7900, 'JIMENO', 'EMPLEADO', 7698, '2014/12/03', 725, 0, 30);
INSERT INTO EMPLE VALUES (7369, 'SÁNCHEZ', 'EMPLEADO', 7900, '2016/12/12', 600, 0, 20);
INSERT INTO EMPLE VALUES (7788, 'GIL', 'ANALISTA', 7566, '2017/04/23', 2350, 0, 20);
INSERT INTO EMPLE VALUES (7876, 'ALONSO', 'EMPLEADO', 7788, '2017/08/09', 860, 0, 20);




/* EJERCICIO 1 TEMA 7*/
/*a) Muestre todos los datos de los empleados del departamento no 10 ordenados por apellido de la A a la Z.*/
select * from emple where dept_no = 10 order by apellido asc;

/*b) Visualice el apellido, fecha de alta y salario de los empleados del departamento no 20 cuyo  oficio sea analista.*/
select apellido,fecha_alt,salario from emple where dept_no = 20 and oficio = "ANALISTA";

/*c) Muestre el número y nombre de todos los departamentos.*/
select dept_no,dnombre from depart;

/*d) Seleccione el número, apellido y oficio de todos los empleados cuyo apellido comience por la letra J.*/
select emp_no,apellido,oficio from emple where apellido like "J%";

/*e) Seleccione todos los datos de los empleados cuyo apellido contenga la letra E en la segunda posición.*/
select * from emple where apellido like "_E%";

/*f) Muestre los apellidos y oficios de los empleados cuyo oficio sea VENDEDOR, ANALISTA o EMPLEADO, ordenando el resultado por apellido.*/
select apellido,oficio from emple where oficio = "VENDEDOR" or oficio = "ANALISTA" or oficio = "EMPLEADO"order by apellido asc;

/*g) Visualice todos los datos de los empleados que cobran más de 2000 € de salario o más de 300€ de comisión.*/
select * from emple where salario >=2000 or comision>=300;

/*h) Visualice todos los datos de los empleados que cobran más de 2000 € de salario y más de 300€ de comisión*/
select * from emple where salario >=2000 and comision>=300;

/*i) Indique para todos los empleados que cobren más de 2000 € su apellido, salario, oficio y comisión, así como el nombre y la localidad del departamento en el que trabaja.*/
/*1*/ select apellido,salario,oficio,comision,dnombre,loc from emple E join depart D on E.dept_no = D.dept_no where salario >=2000 ;
/*2*/ select apellido,salario,oficio,comision,dnombre,loc from emple E, depart D where E.dept_no = D.dept_no and salario >=2000 ;
/*3*/ select apellido,salario,oficio,comision,dnombre,loc from emple E join depart D using (dept_no) where salario >=2000 ;
/*4*/ select apellido,salario,oficio,comision,dnombre,loc from emple E natural join depart D where salario >=2000 ;

/*j)
Indique para todos los empleados que cobran comisión su apellido, el nombre del departamento en el que trabajan, la comisión que cobran, su salario y el porcentaje que supone
la comisión con respecto al salario (PorcenComisión). Redondee este último dato a 2 decimales, para lo que puede hacer uso de la función round, que recibe como primer parámetro el número que se desea redondear y como segundo el número de decimales que se desean en el resultado. 
*/
select apellido,dnombre,comision,salario,round(salario / comision,2) "PorcenComisión" from emple E join depart D on E.dept_no = D.dept_no where comision>0;
/*k)
Indique para el empleado que no tiene jefe o director su apellido, oficio, nombre del
departamento y localidad en la que trabaja.
*/
select apellido,oficio,dnombre,loc from emple E join depart D on E.dept_no = D.dept_no where dir is null;
/*l)
Añada un nuevo departamento a la tabla Depart, con número 40, nombre PRODUCCCIÓN y
ubicado en BILBAO.Muestre a continuación para los departamentos con número superior o igual a 30, su nombre y
localidad y, en caso de que trabaje en él algún empleado, su apellido, salario y comisión.
*/
INSERT INTO DEPART VALUES (40, 'PRODUCCIÓN', 'BILBAO');
select dnombre,loc,apellido,salario,comision from depart D left outer join emple E on E.dept_no = D.dept_no  where D.dept_no >= 30;

/* EJERCICIO 1 TEMA 8 PARTE 1*/

/*a)
Indique por cada oficio que sea desempeñado por más de dos empleados, el nombre del oficio, el número de empleados que lo desempeñan (columna NoEmpleados), la
suma de sus salarios (columna SumaSalarial), la suma de sus comisiones (columna SumaComisiones), el salario máximo y el salario mínimo (columnas SalMax y SalMín). Ordene el resultado por suma salarial en orden descendente.
*/
select oficio,count(oficio) "NoEmpleados",sum(salario) "SumaSalarial",sum(comision)"SumaComisiones",max(salario) "SalMax",min(salario)"SalMín" from emple group by oficio having count(oficio) >=2 order by sum(salario) desc  ;
/*b)
Solo consideraremos a los empleados no analistas. Pues bien, indique por cada departamento con un salario medio de sus empleados no analistas superior a 1200 €, 
el número del departamento, el número de empleados no analistas y su salario medio, ordenando el resultado por el número de empleados de cada departamento.
*/
select D.dept_no,count(E.oficio) "NoEmpleados",round(avg(E.salario),2) "MediaSalario" from depart D join emple E on E.dept_no = D.dept_no where E.oficio != "ANALISTA"  group by D.dept_no having round(avg(E.salario),2) > 1200 order by count(E.oficio) desc;

/*c)
Indique por cada número de departamento y oficio, el número de empleados que desempeñan ese oficio en ese departamento, así como su salario mínimo y máximo.
Ordene el resultado por número de departamento y oficio.
*/
select D.dept_no,E.oficio,count(E.oficio) "NoEmpleados",min(E.salario) "SalMin",max(E.salario) "SalMax" from depart D join emple E on E.dept_no = D.dept_no group by dept_no,oficio order by dept_no,oficio desc;

/*d)
Indique para los departamentos con salario medio superior a 1400 € su número, nombre,
el salario medio de sus empleados y el salario máximo y mínimo.
*/
select dnombre,round(avg(E.salario),2) "MediaSalario" ,min(E.salario) "SalMin",max(E.salario) "SalMax" from depart D join emple E on E.dept_no = D.dept_no group by D.dept_no having round(avg(E.salario),2) > 1400;

/*e)
Indique para todos los empleados que trabajan en el departamento de VENTAS su apellido, salario, comisión, apellido de su jefe (columna Jefe), salario de este 
(columna Salario Jefe) y el resultado de dividir el salario del jefe entre el del empleado (columna Factor Multiplicador) redondeado a dos decimales.
*/
select apellido,salario,comision,(select apellido from emple where E.dir = emp_no) "Jefe",(select salario from emple where E.dir = emp_no) "Salario Jefe", round((select salario from emple where E.dir = emp_no)/E.salario,2) "Factor Multiplicador"from emple E join depart D on E.dept_no = D.dept_no ;

/*f)
Visualice el número de vendedores del departamento de VENTAS.
*/
select count(E.emp_no)"Número de vendedores" from emple E join depart D on E.dept_no = D.dept_no where D.dnombre = "VENTAS" ;


/* EJERCICIO 1 TEMA 8 PARTE 2*/
/*a)
Visualice los nombres de los departamentos en los que el salario medio es mayor o igual que la media de todos los salarios.
*/
select dnombre from depart D join emple E on E.dept_no = D.dept_no group by E.dept_no having (select avg(salario) from emple)<=avg(E.salario);

/*b)
Seleccione el apellido, oficio y localidad de los empleados que trabajan en los
departamentos donde trabajan los analistas.
*/
select E.apellido,E.oficio,D.loc from emple E join depart D on E.dept_no = D.dept_no where E.oficio = "ANALISTA";

/*c)
Muestre el apellido, oficio, salario y fecha de alta de los empleados que desempeñen el
mismo oficio que JIMÉNEZ o que tengan un salario mayor o igual que el de
ARROYO.
*/
select apellido,oficio,salario,fecha_alt from emple E where oficio = (select oficio from emple where apellido= "JIMÉNEZ") or salario >=  (select salario from emple  where apellido= "ARROYO") ;
/*d)
Muestre los apellidos y oficios de los empleados que tienen el mismo oficio que
JIMÉNEZ, excluido este.
*/
select apellido,oficio from emple E where oficio = (select oficio from emple where apellido= "JIMÉNEZ") and E.apellido !="JIMÉNEZ"  ;

/*e)
Obtenga los nombres de los departamentos en los que trabajen más de dos empleados mediante una 
consulta de resumen con combinación de tablas y mediante una consulta con subconsulta.
*/
select dnombre from depart D where (select count(dept_no) from emple where dept_no = D.dept_no)>=2 group by dnombre;
/*f)
Cree una nueva tabla llamada Vendedores con el número, apellido y salario de los
empleados con tal oficio y el nombre del departamento en el que trabajan y la localidad.
*/
CREATE TABLE Vendedores AS select E.emp_no,E.apellido,E.salario,D.dnombre,D.loc from emple E join depart D on D.dept_no = E.dept_no where E.oficio = "VENDEDOR";
select * from Vendedores;
/*g)
Cree una nueva tabla llamada Vendedores con el número, apellido y salario de los
empleados con tal oficio y el nombre del departamento en el que trabajan y la localidad.
*/
CREATE TABLE DeparEmple AS select D.dept_no,D.dnombre,D.loc, count(E.dept_no) "N Empleados",round(avg(E.salario)) "Salario medio" from depart D join emple E on D.dept_no = E.dept_no group by D.dept_no;
select * from DeparEmple;
/*h)
Muestre para los empleados con mayor salario de su departamento, el apellido del
empleado, su salario y el nombre del departamento en el que trabajan.
*/
select apellido,salario,D.dnombre from emple E join depart D on D.dept_no = E.dept_no where (select max(salario) from emple where dept_no = E.dept_no) = E.salario;

/* EJERCICIO 1 TEMA 9*/
/*a)
Cree una tabla llamada Depart2 con el contenido de la tabla Depart, y otra llamada
Emple2 con el contenido de la tabla Emple.
*/
create table Depart2 select * from depart;
create table Emple2 select * from emple;
select * from Emple2;
select * from Depart2;
/*b)
Añada un nuevo departamento a la tabla Depart2 con código 50, nombre RRHH y
ubicado en Burgos.
*/
insert into depart2 values (50,"RRHH","BURGOS");
/*c)
Añada un empleado nuevo a la tabla Emple2 con número 4488, apellidado Gómez,
oficio director, dado de alta el 23 de febrero de 2014, con salario 1800 €, comisión 0 €
y número de departamento el 20.
*/
insert into emple2 values (4488,"GÓMEZ","DIRECTOR",NULL,"2014/02/23",1800,0,20);
/*d)
Divida por 2 la comisión a todos los empleados de la tabla Emple2 que la cobran.
*/
SET SQL_SAFE_UPDATES = 0;
update Emple2 set comision= comision/2 where comision >=1;
/*e)
Asigne el departamento 10 a todos los directores de la tabla Emple2.
*/
update Emple2 set dept_no=10 where oficio ="DIRECTOR";
/*f)
Elimine de la tabla Emple2 a los empleados con fecha de alta en el año 2016.
*/
delete from Emple2 where year(fecha_alt) = 2016;
/*g)
Elimine de la tabla Depart2 los departamentos que no tengan empleados.
*/
delete from Depart2 D where (select count(apellido) from Emple2 where D.dept_no= dept_no ) = 0;
/*h)
Multiplique por 2 la comisión a todos los empleados del departamento de Ventas con
una comisión inferior a 300 €.
*/
update Emple2 set comision= comision*2 where comision <=300 and dept_no = 30;
/*i)
Multiplique por 2 la comisión a todos los empleados del departamento de Ventas con
una comisión inferior a 300 €.
*/
update Depart2 set loc= "MÁLAGA" where dnombre= "CONTABILIDAD";
/*j)
Añada un nuevo empleado a la tabla Emple2 con número 4000, apellido BAUTE, fecha
de alta, la del día de hoy, salario el mismo que el de AGUIRRE más el 15%, siendo el
resto de los datos los mismos que los de AGUIRRE.
*/
insert into Emple2 select 4000,"BAUTE",oficio,dir,current_date(),(salario+ (salario *0.15)),comision,dept_no from Emple2 where apellido ="ARROYO";
/*K)
Aumente un 2,5% el salario y disminuya un 1% la comisión a todos los empleados de
la tabla Emple2 que trabajen el departamento de VENTAS.
*/
update Emple2 set salario= (salario+ ((salario *2.5)/100)),comision= (comision- ((comision *1)/100)) where dept_no =30;
