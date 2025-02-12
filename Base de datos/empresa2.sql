

CREATE TABLE HABILIDAD
(CodHab CHAR (5) PRIMARY KEY,
DesHab VARCHAR(30) NOT NULL UNIQUE);

INSERT INTO HABILIDAD VALUES ('FONTA', 'Fontanería');
INSERT INTO HABILIDAD VALUES ('GEREN', 'Gerencia');
INSERT INTO HABILIDAD VALUES ('GESCO', 'Gestión Contable');
INSERT INTO HABILIDAD VALUES ('MARKE', 'Márketing');
INSERT INTO HABILIDAD VALUES ('MECAN', 'Mecanografía');
INSERT INTO HABILIDAD VALUES ('RELPU', 'Relaciones Públicas');
INSERT INTO HABILIDAD VALUES ('TELEF', 'Telefonista');

CREATE TABLE CENTRO
(CodCen CHAR(4) PRIMARY KEY,
CodEmpDir int,
NomCen VARCHAR(30) NOT NULL,
DirCen VARCHAR(50) NOT NULL);

ALTER TABLE CENTRO ADD (PobCen VARCHAR(20) NOT NULL);

INSERT INTO CENTRO VALUES ('DIGE', 1, 'Dirección General', 'Av. Constitución 88', 'Murcia');
INSERT INTO CENTRO VALUES ('FAZS', 6, 'Fábrica Zona Sur', 'Pol. Industrial Gral. Bastarreche', 'Cartagena');
INSERT INTO CENTRO VALUES ('OFZS', 6, 'Oficinas Zona Sur', 'Pl. España 14', 'Cartagena');

CREATE TABLE DEPARTAMENTO 
(CodDep CHAR(5) PRIMARY KEY,
CodEmpDir int,
CodDepDep CHAR(5),
foreign key (CodDepDep) references Departamento (CodDep) on delete cascade,
CodCen CHAR(4),
foreign key (CodCen) REFERENCES Centro (CodCen) ON DELETE CASCADE,
NomDep VARCHAR(40) NOT NULL,
PreAnu float NOT NULL,
TiDir enum('F', 'P') NOT NULL);

INSERT INTO DEPARTAMENTO VALUES ('DIRGE', 1, NULL,'DIGE', 'Dirección General', 156000, 'P');
INSERT INTO DEPARTAMENTO VALUES ('INYDI', 2, 'DIRGE', 'DIGE', 'Investigación y Diseño', 150000, 'P');
INSERT INTO DEPARTAMENTO VALUES ('JEFZS',6, 'DIRGE',NULL, 'Jefatura Fábrica Zona Sur', 37200, 'F');
INSERT INTO DEPARTAMENTO VALUES ('ADMZS', 5,'JEFZS', NULL,  'Administración Zona Sur', 84000, 'P');
INSERT INTO DEPARTAMENTO VALUES ('PROZS', 9, 'JEFZS', 'FAZS',  'Producción Zona Sur', 600000, 'P');
INSERT INTO DEPARTAMENTO VALUES ('VENZS', 3, 'ADMZS','OFZS', 'Ventas Zona Sur', 81000, 'F');

 
CREATE TABLE EMPLEADO
(CodEmp int PRIMARY KEY,
CodDep CHAR(5),
foreign key (CodDep) REFERENCES Departamento (CodDep) ON DELETE CASCADE,
ExTelEmp int,
FecInEmp DATE NOT NULL, 
FecNaEmp DATE NOT NULL,
NIFEmp CHAR(9) NOT NULL UNIQUE,
NomEmp VARCHAR (40) NOT NULL,
NumHi int DEFAULT 0 NOT NULL,
SalEmp float NOT NULL);

INSERT INTO EMPLEADO  VALUES (5, 'ADMZS', 1239,  '1976/08/07', '1958/03/08', '38223923T', 'Alada Veraz, Juana', 1, 37200); 
INSERT INTO EMPLEADO  VALUES (7, 'PROZS', NULL,  '1994/06/30', '1975/08/07', '47123132D', 'Forzado López, Galeote', 0, 9600); 
INSERT INTO EMPLEADO VALUES (6, 'JEFZS', 23838, '1991/08/01', '1969/06/03', '26454122D', 'Gozque Altanero, Cándido', 1, 30000); 
INSERT INTO EMPLEADO  VALUES (9, 'PROZS', 12124, '1987/06/10', '1968/07/19', '11312121D', 'Mando Correa, Rosa', 2, 18600); 
INSERT INTO EMPLEADO  VALUES (2, 'INYDI', 2233, '1991/06/14', '1970/06/08', '21231347K', 'Manrique Bacterio, Lucía', 0, 27000); 
INSERT INTO EMPLEADO VALUES (8, 'PROZS', NULL,  '1994/08/15', '1976/06/15', '32132154H', 'Mascullas Alto, Eloísa', 1, 9600); 
INSERT INTO EMPLEADO  VALUES (3, 'VENZS', 2133, '1984/06/08','1965/12/07', '23823930D', 'Monforte Cid, Roldán', 1, 31200); 
INSERT INTO EMPLEADO  VALUES ( 10, 'PROZS', NULL,  '1993/11/02','1975/01/07', '32939393D', 'Mox Almuerta, Mario', 0, 7800); 
INSERT INTO EMPLEADO VALUES (1, 'DIRGE', 1111, '1982/07/01','1961/08/07', '21451451V', 'Saladino Manda, Augusto', 1, 43200); 
INSERT INTO EMPLEADO  VALUES (4, 'VENZS', 3838, '1990/08/09', '1970/02/21', '38293923L', 'Topaz Illan, Carlos', 0, 19200); 


ALTER TABLE CENTRO
ADD CONSTRAINT FK_Director_Centro FOREIGN KEY (CodEmpDir) REFERENCES EMPLEADO (CodEmp) ON DELETE CASCADE;

ALTER TABLE DEPARTAMENTO
ADD CONSTRAINT FK_Director_Departamento FOREIGN KEY (CodEmpDir) REFERENCES EMPLEADO (CodEmp) ON DELETE CASCADE;

CREATE TABLE HIJO 
(CodEmp int,
foreign key (CodEmp) REFERENCES EMPLEADO (CodEmp) ON DELETE CASCADE,
NumHij int,
FecNaHi DATE NOT NULL,
NomHi VARCHAR(40) NOT NULL,
PRIMARY KEY (CodEmp, NumHij));

INSERT INTO HIJO VALUES (8,1, '1994/03/14', 'Fuerte Mascullas, Anacleto');
INSERT INTO HIJO VALUES (9,1, '1988/02/28', 'León Mando, Elvira');
INSERT INTO HIJO VALUES (9,2, '1990/07/18', 'León Mando, Plácido'); 
INSERT INTO HIJO VALUES (3,1, '1990/09/12', 'Monforte Lemos, Jesús'); 
INSERT INTO HIJO VALUES (5,1, '1982/02/06', 'Pastora Alada, Mateo'); 
INSERT INTO HIJO VALUES (1,1, '1989/06/07', 'Saladino Oropel, Flavia');

CREATE TABLE HABEMP
(CodHab CHAR (5),
foreign key (CodHab) REFERENCES HABILIDAD (CodHab) ON DELETE CASCADE,
CodEmp int,
foreign key (CodEmp) REFERENCES EMPLEADO (CodEmp) ON DELETE CASCADE,
NivHab int DEFAULT 5 NOT NULL CHECK (NivHab BETWEEN 0 AND 10),
PRIMARY KEY (CodHab, CodEmp));

INSERT INTO HABEMP VALUES ('GEREN', 1, 10);
INSERT INTO HABEMP VALUES ('RELPU', 1, 9);
INSERT INTO HABEMP VALUES ('MARKE', 3, 9);
INSERT INTO HABEMP VALUES ('MARKE', 4, 6);
INSERT INTO HABEMP VALUES ('GESCO', 5, 9);
INSERT INTO HABEMP VALUES ('RELPU', 5, 8);
INSERT INTO HABEMP VALUES ('FONTA', 8, 7);

COMMIT;

/* EJERCICIO 2 TEMA 7*/

/*a)
Muestre por cada empleado su código, nombre, salario y el nombre del departamento en el
que trabaja.
*/
select CodEmp,NomEmp,SalEmp,NomDep from Empleado E join Departamento D on E.CodDep = D.CodDep;
/*b)
Muestre por cada departamento su código, nombre y el nombre del empleado que lo
dirige.
*/
select D.CodDep,D.NomDep,NomEmp from Departamento D join Empleado E on D.CodEmpDir = E.CodEmp;
/*c)
Muestre por cada empleado su nombre y por cada una de las habilidades que posee, el
código de la habilidad, la descripción de la habilidad y el nivel correspondiente.
*/
select NomEmp,HE.CodHab,H.DesHab,HE.NivHab from Empleado E join HabEmp HE on HE.CodEmp = E.CodEmp join Habilidad H on H.CodHab = HE.CodHab;
/*d)
Muestre el nombre y salario de todos los empleados con salario superior a 30000 €, así
como el porcentaje que supone su salario sobre el presupuesto de su departamento.Redondee el resultado de esta última operación a 2 decimales.
*/
select NomEmp,SalEmp,round(D.PreAnu / SalEmp,2) "Porcentaje" from Empleado E join Departamento D on E.CodDep = D.CodDep where SalEmp >=3000 ;
/*e)
Muestre por cada empleado nacido después de 1969 su nombre, extensión telefónica,fecha de nacimiento, nombre del departamento en el que trabaja y nombre del centro en el
que este está ubicado. Ordene el resultado por edad de los empleados del más joven al de mayor edad.
*/
select NomEmp,ExTelEmp,FecNaEmp,NomDep,C.CodCen from Empleado E join Departamento D on E.CodDep = D.CodDep join Centro C on D.CodCen = C.CodCen where YEAR(FecNaEmp) >=1969 order by FecNaEmp desc;
/*f)
Muestre los nombres y salarios de los empleados que tienen hijos nacidos después del año1990.
*/
select NomEmp,SalEmp from Empleado E join Hijo H on H.CodEmp = E.CodEmp where YEAR(FecNaHi) >=1990 ;
/*g)
Muestre para todos los centros de trabajo, su nombre y dirección, así como el nombre del 
empleado que lo dirige, su extensión telefónica y su salario. Ordene el resultado por nombre de centro.
*/
select NomCen,DirCen from Empleado E join Hijo H on H.CodEmp = E.CodEmp where YEAR(FecNaHi) >=1990 ;
/*h)
Muestre para el departamento que no depende de ningún otro departamento, su nombre, presupuesto, el nombre del centro en el que está ubicado, así como su dirección y elnombre del empleado que dirige dicho departamento.
*/
select NomDep,PreAnu,NomCen,DirCen,NomEmp from Departamento D join Centro C on D.CodCen = C.CodCen join Empleado E on E.CodEmp = D.CodEmpDir  where CodDepDep is null;

/* EJERCICIO 1 ADICIONALES TEMA 7*/

/*a)
Liste el NIF, nombre y complemento familiar (con dos decimales) de los empleados con hijos, sabiendo que el complemento familiar se calcula de acuerdo con la siguientefórmula:
Complemento familiar = ((4 x Número de hijos) / 100 ) x Salario
*/
select NifEmp,NomEmp,round((4*NumHi/100)*SalEmp,2) "Complemento familiar" from Empleado;

/*b)
Muestre ordenados alfabéticamente los nombres de los empleados del centro Fábrica Zona Sur que tienen hijos nacidos antes de su contratación por la empresa.
*/
select NomEmp from Empleado E join Departamento D on E.CodDep = D.CodDep join Centro C on D.CodCen = C.CodCen left outer join Hijo H on H.CodEmp = E.CodEmp  where NomCen ="Fábrica Zona Sur" and FecNaHi<FecInEmp order by NomEmp asc;

/*c)
Muestre los nombres de los departamentos donde haya al menos un trabajador cuyo
salario suponga más del 25% del presupuesto del departamento.
*/
select NomDep from Departamento D left outer join Empleado E on E.CodDep = D.CodDep where E.SalEmp>((D.PreAnu * 25)/100);
/*d)
Muestre para los empleados que poseen habilidades con nivel superior o igual a 9, el nombre del empleado, la descripción de la habilidad y el nivel.
*/
select NomEmp,H.DesHab,HE.NivHab from Empleado E join HabEmp HE on HE.CodEmp = E.CodEmp join Habilidad H on H.CodHab = HE.CodHab where HE.NivHab >= 9;

/* EJERCICIO 2 TEMA 8 PARTE 1*/
/*a)
Muestre por cada centro de trabajo, su nombre y dirección, así como el número de departamentos en que se divide 
y el presupuesto máximo y mínimo de sus departamentos.
*/
select NomCen,DirCen,count(D.CodDep)"N Departamentos",max(D.PreAnu)"PreAnuMax", min(D.PreAnu)"PreAnuMin" from Departamento D join Centro C on C.CodCen = D.CodCen group by C.CodCen;

/*b)
Muestre por cada habilidad su código y descripción, el número de empleados que la
poseen y el nivel medio de dicha habilidad.
*/
select H.CodHab,H.DesHab,count(HE.CodEmp)"N Empleados",round(avg(HE.NivHab),1) "NivHabMedia" from HabEmp HE join Empleado E on HE.CodEmp = E.CodEmp join Habilidad H on H.CodHab = HE.CodHab group by H.CodHab;

/* EJERCICIO 2 TEMA 8 PARTE 2*/
/*a)
Para todos los departamentos con un presupuesto superior a la media, muestre el
código del departamento, su nombre, su presupuesto, su tipo de director y el nombre de su director.
*/
select D.CodDep,NomDep,PreAnu,TiDIr,E.NomEmp "NomDir" from Departamento D join Empleado E on E.CodEmp = D.CodEmpDir where (select avg(PreAnu) from Departamento)> PreAnu;
/*b)
Para todos los empleados que cobren más que el salario medio de todos los empleados,
muestre el nombre del empleado, su salario, su extensión telefónica, el nombre del departamento
en el que trabaja y el nombre del centro en el que está ubicado su departamento.
*/
select NomEmp,SalEmp,ExTelEmp,D.NomDep,C.NomCen from Empleado E join Departamento D on E.CodEmp = D.CodEmpDir where (select avg(PreAnu) from Departamento)> PreAnu;
/*c)
Obtenga la descripción de la habilidad con nivel más alto mediante una consulta con
una subconsulta y mediante una consulta con dos subconsultas anidadas.
*/
select DesHab from HabEmp HE join Habilidad H on H.CodHab = HE.CodHab where (select max(NivHab) from HabEmp)=HE.NivHab;

/* EJERCICIO 2 TEMA 9*/

/*a)
Cree la tabla EmpDep (CodEmp, NomEmp, SalEmp, NomDep) cuyas columnas tienen
el mismo tipo y tamaño que las homónimas de otras tablas existentes en la base de
datos. Inserte en dicha tabla el código, nombre y salario de los empleados que trabajen
en centros ubicados en Murcia, así como el nombre del departamento en el que
trabajan. */
create table EmpDep select CodEmp,NomEmp,SalEmp,NomDep from Empleado E join Departamento D on E.CodDep=D.CodDep join Centro C on D.CodCen=C.CodCen where C.PobCen ="Murcia";
select * from EmpDep;
/*b)
Incremente en la tabla EmpDep en un 8 % el sueldo de los empleados que trabajen en
el departamento llamado Dirección General.
*/
update EmpDep set SalEmp= (SalEmp+ ((SalEmp *8)/100)) where NomDep ="Dirección General";
/*c)
Inserte en la tabla EmpDep un empleado con código 99, nombre Pérez Ruiz, María,
salario 15000 € y departamento Ventas Zona Sur.
*/
insert into EmpDep values (99,"Pérez Ruiz,Maria",15000,"Ventas Zona Sur");
/*d)
Borre de la tabla EmpDep a los empleados que cobren más de 20000 € y que trabajen
en el departamento con código INYDI.
*/
delete from EmpDep where SalEmp>=20000 and NomDep="Investigación y Diseño";
/*e)
Asigne en la tabla EmpDep al empleado que trabaja en el departamento con código
DIRGE, el salario máximo de los empleados de la tabla Empleado que trabajan en el
departamento con código VENZS.
*/
update EmpDep set SalEmp= (select max(SalEmp) from Empleado where CodDep="VENZS" )where NomDep ="Dirección General";
