create database empresa collate utf8mb4_spanish_ci;

use empresa;

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


/*TEMA 10: EJERCICIO 2*/
/*a) Cree un rol llamado RolRRHH que tenga otorgados los privilegios necesarios
para consultar las tablas Emple y Depart, crear, alterar y eliminar tablas en la
base de datos Empresa y además añadir nuevos empleados a la tabla Emple y
modificar los atributos oficio, dir, salario, comisión y dept_no de dicha tabla.
*/

create role RolRRHH;
grant insert,select,create,update(oficio,dir,salario,comisión,dept_no),delete on empresa.Emple to RolRRHH;
grant select,create,delete on empresa.Depart to RolRRHH ;
grant create,update,delete on empresa.* to RolRRHH ;

/*b) Cree tres usuarios llamados rrhh1, rrhh2 y rrhh3 con la contraseña que desee, la
cual deberá expirar en 30 días. Estos usuarios tendrán como rol por defecto el rol
RolRRHH.
*/

create user rrhh1 identified by "1234" default role RolRRHH PASSWORD EXPIRE interval 30 day;
create user rrhh2 identified by "1234" default role RolRRHH PASSWORD EXPIRE interval 30 day;
create user rrhh3 identified by "1234" default role RolRRHH PASSWORD EXPIRE interval 30 day;

/*c) Entre al sistema con el usuario rrhh2 y compruebe que puede consultar la tabla
Depart y cambiar el salario de un empleado en la tabla Emple, pero que no puede
crear nuevos departamentos. Visualice los privilegios que tiene otorgados el
usuario rrhh2.
*/
show grants for rrhh2;


/*TEMA 10: EJERCICIO 3*/
/*a) Cree una vista llamada VistaEmpleDep que sea el resultado de una combinación
entre las tablas Emple y Depart y que contenga por cada empleado su apellido,
su salario, su antigüedad (calculada como la diferencia de años entre la fecha de
hoy y la fecha de alta) y el nombre del departamento en el que trabaja. Los
nombres de los atributos de la vista deben ser apellido, salario, antigüedad y
departamento. Para calcular la antigüedad, MySQL nos proporciona la función
timestampdiff (unidad_tiempo, fecha1, fecha2) que recibe como parámetro una
unidad de tiempo (year, month, week, day, etc.) y dos fechas tal que fecha2 es
superior o igual a fecha1. Esta función nos devuelve la diferencia entre esas dos
fechas en la unidad de tiempo indicada como primer parámetro. Por otro lado, la
expresión current_date nos devuelve la fecha de hoy.
*/
create view VistaEmpleDep as select apellido,salario,TIMESTAMPDIFF(YEAR, fecha_alt, CURRENT_TIMESTAMP()) "antiguedad",dnombre "departamento" from Emple E join Depart D on E.dept_no = D.dept_no;
/*b) Realice una consulta sobre la vista VistaEmpleDep que muestre por cada
departamento, su número de empleados.
*/
select departamento,count(apellido)"Número de empleados" from VistaEmpleDep VED group by departamento;

/*c) Intente modificar la antigüedad de GIL a 6 años. ¿Es posible realizar esta
modificación? ¿Por qué? --> NO SE PUEDE porque es un campo calculado
*/
/*d) Intente modificar el apellido de GIL por GILA. ¿Es posible realizar esta
modificación? ¿Por qué?
*/
update VistaEmpleDep set apellido="GILA" where apellido="GIL";

/*TEMA 10: EJERCICIO 4*/
/*a) Cree una vista llamada VistaEmple que contenga por cada empleado su número,
apellido, fecha de alta y número de departamento en el que trabaja para todos los
empleados con fecha de alta en el año 2014. Muestre el contenido de la vista.
*/
create view VistaEmple as select emp_no,apellido,fecha_alt,dept_no from Emple E where YEAR(fecha_alt) = 2014;
/*b) Intente añadir un nuevo empleado a través de la vista VistaEmple indicando
como número de empleado el 7777, apellido GARCÍA, fecha de alta el 31 de
diciembre de 2019 y número de departamento el 10. ¿Qué ocurre en la tabla
Emple? --> El insert resulta en error, no se puede insertar en una vista
*/
insert into VistaEmple values(777,"GARCIA","2019/12/31",10);
/*c) ¿Se puede modificar a través de la vista VistaEmple el departamento en el que
trabaja TOVAR de manera que sea el número 20? ¿Por qué? --> Si se puede modificar
*/
update VistaEmple set dept_no=20 where apellido="TOVAR";

/*d)Elimine, si es posible, al empleado apellidado TOVAR a través de la vista
VistaEmple.*/
delete from VistaEmple where apellido="TOVAR";