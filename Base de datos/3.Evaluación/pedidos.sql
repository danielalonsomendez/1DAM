
create database pedidos collate utf8mb4_spanish_ci;

use pedidos;

create table pedido
(refped char(5) primary key,
fecped date not null);

create table articulo
(CodArt char(5) primary key,
DesArt varchar(30) not null,
PVPArt float not null constraint ch_PVPArt check (PVPArt > 0));

create table LineaPedido
(RefPed char(5),
CodArt char(5),
CantArt int not null default 1 
        constraint ch_CantArt check (CantArt > 0),
constraint fk_RefPed_LineaPedido foreign key (RefPed) references Pedido(RefPed) on update cascade,
constraint fk_CodArt_LineaPedido foreign key (CodArt) references Articulo(CodArt) on update cascade,
constraint pk_LineaPedido primary key (RefPed, CodArt));

INSERT INTO PEDIDO VALUES ('P0001', '2018-02-16');
INSERT INTO PEDIDO VALUES ('P0002', '2018-02-18');
INSERT INTO PEDIDO VALUES ('P0003', '2018-02-23');
INSERT INTO PEDIDO VALUES ('P0004', '2018-02-25');

INSERT INTO ARTICULO VALUES ('A0043', 'Bolígrafo azul', 0.78);
INSERT INTO ARTICULO VALUES ('A0078', 'Bolígrafo rojo normal', 1.05);
INSERT INTO ARTICULO VALUES ('A0075', 'Lápiz 2B', 0.55);
INSERT INTO ARTICULO VALUES ('A0012', 'Goma de borrar', 0.15);
INSERT INTO ARTICULO VALUES ('A0089', 'Sacapuntas', 0.25);

INSERT INTO LINEAPEDIDO VALUES ('P0001', 'A0043', 10);
INSERT INTO LINEAPEDIDO VALUES ('P0001', 'A0078', 12);
INSERT INTO LINEAPEDIDO VALUES ('P0002', 'A0043', 5);
INSERT INTO LINEAPEDIDO VALUES ('P0003', 'A0075', 20);
INSERT INTO LINEAPEDIDO VALUES ('P0004', 'A0012', 15);
INSERT INTO LINEAPEDIDO VALUES ('P0004', 'A0043', 5);
INSERT INTO LINEAPEDIDO VALUES ('P0004', 'A0089', 50);

/*TEMA 10: EJERCICIO 1*/

/*a) Cree un usuario llamado adminpedidos con la contraseña que desee y que tenga
todos los privilegios sobre todas las tablas de la base de datos Pedidos. Permita
que este usuario pueda pasar sus privilegios a otros usuarios.*/

create user adminpedidos identified by "1234";
grant all on Pedidos.* to adminpedidos with grant option;

/*b) Cree un segundo usuario llamado consulpedidos con la contraseña que desee,
que pueda consultar el contenido de cualquiera de las tablas de la base de datos
Pedidos y que además pueda crear tablas, eliminar tablas, modificar el diseño de
las tablas creadas, crear vistas y crear y borrar índices, todo ello en la base de
datos Pedidos. Compruebe que efectivamente puede en dicha base de datos
consultar tablas, pero que no puede añadir filas a las mismas.
*/

create user consulpedidos identified by "1234";
grant select,create,delete,drop,update,show view,index on Pedidos.* to consulpedidos;

/*c) Cree un tercer usuario procpedidos que solo se pueda conectar desde el equipo
local con la contraseña que desee y que tenga las siguientes limitaciones: el
número máximo de consultas y actualizaciones que puede hacer por hora son 30
y el número máximo de conexiones simultáneas de ese usuario son 4. Este
usuario debe poder crear y modificar rutinas almacenadas en la base de datos
Pedidos. Compruebe las restricciones asignadas en la tabla User de la base de
datos MySQL.
*/

create user procpedidos@localhost identified by "1234" with MAX_QUERIES_PER_HOUR 30 MAX_USER_CONNECTIONS 4;
grant create routine,alter routine on Pedidos.* to procpedidos@localhost;

/*d) Cree un cuarto usuario llamado modifpedidos con la contraseña que desee, que
pueda consultar la tabla Articulo, insertar nuevas filas en dicha tabla, borrar
artículos, modificar los atributos DesArt y PVPArt de los artículos y crear claves
ajenas a la clave primaria de esta tabla. Una vez asignados estos privilegios,
visualice los permisos de este usuario. Compruebe que este usuario puede añadir
un nuevo artículo y luego modificar el precio de dicho artículo, pero no
modificar su código.
*/

create user modifpedidos identified by "1234";
grant select,insert,delete,update (DesArt,PVPArt),references(CodArt) on pedidos.articulo to modifpedidos;


/*e) Retire los privilegios otorgados al usuario procpedidos y después elimine el
usuario.
*/

revoke create routine,alter routine on pedidos.* from procpedidos@localhost; 
drop user procpedidos@localhost; 

/*f) Visualice los privilegios del usuario consulpedidos. Retire a este usuario la
posibilidad de crear, eliminar tablas y modificar su diseño en la base de datos
Pedidos. Visualice a continuación sus privilegios.
*/
show grants for consulpedidos;
revoke create,delete,update on pedidos.* from consulpedidos; 


/* TEMA 11 */
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
//

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
