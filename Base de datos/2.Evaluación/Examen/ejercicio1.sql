/*
create user dam2eva identified by "e2-dam";
create database eva2_dam collate utf8mb3_spanish_ci;
grant all on eva2_dam.* to dam2eva;
*/

/* EJERCICIO 1 */
use eva2_dam;

create table Cliente(
DNI varchar(9) primary key,
nombre varchar(40) not null,
dirección varchar(40) not null,
población varchar(20) not null,
telefono varchar(9),
email varchar(999) constraint  ck_email_Cliente check (email like "%@%")
);

create table Pedido(
num_pedido int primary key auto_increment,
fechahora timestamp default current_timestamp not null,
dni_cliente varchar(9) not null,
constraint fk_dni_cliente_Cliente foreign key (dni_cliente) references Cliente(DNI) on update cascade 
);

create table Hamburguesa(
nom_hamburguesa varchar(40) primary key,
tiempo_prep int not null constraint ck_tiempo_prep_Hamburguesa check(tiempo_prep between 15 and 45),
precio float not null constraint ck_precio_Hamburguesa check(precio between 4.50 and 25)
);

create table LineaPedido(
num_pedido int,
nom_hamburguesa varchar(40),
unidades int default 1 constraint ck_unidades_LineaPedido check(unidades>=1),
constraint fk_num_pedido_Pedido foreign key (num_pedido) references Pedido(num_pedido) on update cascade on delete cascade,
constraint fk_nom_hamburguesa_Hamburguesa foreign key (nom_hamburguesa) references Hamburguesa(nom_hamburguesa) on update cascade
);