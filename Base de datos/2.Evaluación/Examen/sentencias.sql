use eva2_empresa_dam;
/* EJERCICIO 2 */
select 
D.NomDep,
C.PobCen,
E.NomEmp,
D.PreAnu 
from Departamento D 
join Centro C on C.CodCen = D.CodCen 
join Empleado E on E.CodEmp = D.CodEmpDir 
where CodDepDep is null;

/* EJERCICIO 3 */
select 
D.NomDep "Nombre dpto.",
(select round(avg(SalEmp),2) from Empleado where CodDep = D.CodDep) "Salario medio",
(select count(CodEmp) from Empleado where CodDep = D.CodDep)  "Nº empleados",
(select count(ExTelEmp) from Empleado where CodDep = D.CodDep and ExTelEmp is not null) "Extensiones telefónicas",
(select sum(SalEmp) from Empleado where CodDep = D.CodDep) "Salario Total"
from Departamento D
where PreAnu>80000 and (select count(CodEmp) from Empleado where CodDep = D.CodDep) >=2 
order by (select round(avg(SalEmp),2) from Empleado where CodDep = D.CodDep) desc;

/* EJERCICIO 4 */
select 
NomEmp,
SalEmp,
D.NomDep
from  Empleado E
join Departamento D on E.CodDep = D.CodDep
where (select SalEmp from  Departamento DS join Empleado ES on DS.CodEmpDir = ES.CodEmp where DS.NomDep = "Producción Zona Sur") < SalEmp
order by SalEmp desc;
