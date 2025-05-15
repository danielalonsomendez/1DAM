/*GEOGRAFIA*/
use exa3evageografia;
/*UD10: EJ1*/
create view VLocalidadesVascas as select L.nombre "NomLoc",L.poblacion "PobLoc",P.nombre "NomProv" from localidades L join provincias P on P.n_provincia = L.n_provincia join comunidades C on C.id_comunidad = P.id_comunidad where C.id_comunidad = 7;
/*1.1*/ update VLocalidadesVascas set PobLoc = 355000 where NomLoc = "Bilbao";

/*UD10: EJ2*/
create role RolDam;
grant select on exa3evageografia.* to RolDam;
grant insert,delete,update(poblacion) on exa3evageografia.localidades to RolDam;
/*2.1*/ grant alter routine,index,create view, trigger,event on exa3evageografia.* to RolDam;

/*UD10: EJ3*/
create user DAMExamen identified by "asgbd"  default role RolDam with max_user_connections 3 password expire interval 40 day;

/*UD11: EJ1*/
delimiter //
create function Densidad(nomprovincia varchar(30)) returns float reads sql data
begin
declare nprovincia int;
declare superficieprovincia int;
declare poblacionprovincia int;
select n_provincia,superficie into nprovincia, superficieprovincia from provincias where nombre = nomprovincia;
select sum(poblacion) into poblacionprovincia from localidades where n_provincia = nprovincia;
return (poblacionprovincia/superficieprovincia);
end;//

select Densidad("Badajoz")//

/*UD11: EJ2*/
create procedure NumeroProvincias(nombrecomunidad varchar(30))
begin
declare idcomunidad int;
declare numeroprovincias int;
select id_comunidad into idcomunidad from comunidades where nombre = nombrecomunidad;
select count(n_provincia) into numeroprovincias from provincias where id_comunidad =idcomunidad;
if numeroprovincias = 1 then
select concat(nombrecomunidad," es una comunidad autónoma uniprovincial")"Mensaje";
else 
select concat("La comunidad ",nombrecomunidad," consta de ",numeroprovincias," provincias")"Mensaje";
end if;
end;//

call NumeroProvincias("Extremadura")//
call NumeroProvincias("La Rioja")//



/*PIZZERIA*/
use Exa3EvaPizzeria;//
/*UD11: EJ1*/
create procedure subidaPrecioPizza(nombrepizza varchar(30))
begin
declare preciopizza float;
declare subidaprecio float;
select precio into preciopizza from Pizza where nom_pizza = nombrepizza;
if preciopizza is null then
select concat("No existe ninguna pizza con el siguiente nombre: ",nombrepizza)"Mensaje";
else 

if preciopizza <=8 then
select 2 into subidaprecio;
elseif preciopizza> 8 and preciopizza<9 then
select 1.5 into subidaprecio;
elseif preciopizza >=9 then
select 1 into subidaprecio;
end if;

update Pizza set precio = precio+subidaprecio where nom_pizza = nombrepizza;
select concat("El nuevo precio de la pizza ",nombrepizza," es de ", (preciopizza+subidaprecio)," euros")"Mensaje";

end if;
end;
//
call subidaPrecioPizza("Cuatro quesos")//

/*UD12: EJ1*/
create trigger InsertarPedido after insert on Pedido for each row
begin
update Cliente set ultimo_pedido= NEW.fechahora where DNI= NEW.dni_cliente;
update Cliente set num_pedidos= num_pedidos+1 where DNI= NEW.dni_cliente;

end;//

/*Prueba funcionamiento del disparador*/
select dni,ultimo_pedido,num_pedidos from cliente where DNI = "11111111A";//
insert into Pedido (dni_cliente, importe) values ('11111111A',42.5); //
select dni,ultimo_pedido,num_pedidos from cliente where DNI = "11111111A" ;//

/*UD12: EJ2*/
create event RegistrarGastosClienteEvento on schedule every 1 year starts "2025-12-31 23:59:59" enable do call RegistrarGastoCliente();
