/* TEMA 11: EJERCICIO 1*/
/*
1. Cree un procedimiento llamado EliminarPedido que reciba la referencia de un pedido y que
muestre en pantalla dicha referencia y la fecha del pedido y se encargue de eliminarlo de la base
de datos. Debe mostrase un mensaje indicando tal hecho.

*/
delimiter //
create procedure EliminarPedido(RefPedido char(5)) 
begin 
select RefPedido,FecPed,concat("Se ha eliminado el producto ",RefPedido," con fecha ",FecPed) Mensaje from pedido where RefPed = RefPedido;
delete from lineapedido where RefPed =RefPedido; 
delete from pedido where RefPed = RefPedido; 
end;
//
call EliminarPedido("P0003");
drop procedure EliminarPedido;//
/*
2. Cree una función llamada NumPedidos que reciba la descripción de un artículo y que devuelva
un número entero que indique en cuántos pedidos diferentes ha sido solicitado dicho artículo.
*/

create function NumPedidos(Descripcion varchar(30)) returns int DETERMINISTIC
begin
return (select count(A.DesArt) from LineaPedido LP join Articulo A on LP.CodArt=A.CodArt where A.DesArt = Descripcion );
end;
//
select NumPedidos("Bolígrafo azul");
